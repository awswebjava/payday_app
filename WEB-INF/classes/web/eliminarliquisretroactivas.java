package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarliquisretroactivas extends GXProcedure
{
   public eliminarliquisretroactivas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarliquisretroactivas.class ), "" );
   }

   public eliminarliquisretroactivas( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      eliminarliquisretroactivas.this.AV10CliCod = aP0;
      eliminarliquisretroactivas.this.AV9EmpCod = aP1;
      eliminarliquisretroactivas.this.AV8LiqRelNro = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01Z22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LiqRelNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01Z22_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01Z22_n2112LiqRelNro[0] ;
         A1EmpCod = P01Z22_A1EmpCod[0] ;
         A3CliCod = P01Z22_A3CliCod[0] ;
         A31LiqNro = P01Z22_A31LiqNro[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "elimina retro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
         new web.eliminaliquidacion(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01Z22_A2112LiqRelNro = new int[1] ;
      P01Z22_n2112LiqRelNro = new boolean[] {false} ;
      P01Z22_A1EmpCod = new short[1] ;
      P01Z22_A3CliCod = new int[1] ;
      P01Z22_A31LiqNro = new int[1] ;
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarliquisretroactivas__default(),
         new Object[] {
             new Object[] {
            P01Z22_A2112LiqRelNro, P01Z22_n2112LiqRelNro, P01Z22_A1EmpCod, P01Z22_A3CliCod, P01Z22_A31LiqNro
            }
         }
      );
      AV14Pgmname = "EliminarLiquisRetroactivas" ;
      /* GeneXus formulas. */
      AV14Pgmname = "EliminarLiquisRetroactivas" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LiqRelNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private String AV14Pgmname ;
   private boolean n2112LiqRelNro ;
   private IDataStoreProvider pr_default ;
   private int[] P01Z22_A2112LiqRelNro ;
   private boolean[] P01Z22_n2112LiqRelNro ;
   private short[] P01Z22_A1EmpCod ;
   private int[] P01Z22_A3CliCod ;
   private int[] P01Z22_A31LiqNro ;
}

final  class eliminarliquisretroactivas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z22", "SELECT LiqRelNro, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqRelNro = ? ORDER BY CliCod, EmpCod, LiqRelNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

