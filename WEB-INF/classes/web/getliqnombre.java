package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqnombre extends GXProcedure
{
   public getliqnombre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqnombre.class ), "" );
   }

   public getliqnombre( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getliqnombre.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getliqnombre.this.AV11CliCod = aP0;
      getliqnombre.this.AV8EmpCod = aP1;
      getliqnombre.this.AV10LiqNro = aP2;
      getliqnombre.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01FF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P01FF2_A31LiqNro[0] ;
         A1EmpCod = P01FF2_A1EmpCod[0] ;
         A3CliCod = P01FF2_A3CliCod[0] ;
         A874LiqNombre = P01FF2_A874LiqNombre[0] ;
         AV9LiqNombre = A874LiqNombre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqnombre.this.AV9LiqNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqNombre = "" ;
      scmdbuf = "" ;
      P01FF2_A31LiqNro = new int[1] ;
      P01FF2_A1EmpCod = new short[1] ;
      P01FF2_A3CliCod = new int[1] ;
      P01FF2_A874LiqNombre = new String[] {""} ;
      A874LiqNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqnombre__default(),
         new Object[] {
             new Object[] {
            P01FF2_A31LiqNro, P01FF2_A1EmpCod, P01FF2_A3CliCod, P01FF2_A874LiqNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV9LiqNombre ;
   private String A874LiqNombre ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01FF2_A31LiqNro ;
   private short[] P01FF2_A1EmpCod ;
   private int[] P01FF2_A3CliCod ;
   private String[] P01FF2_A874LiqNombre ;
}

final  class getliqnombre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FF2", "SELECT LiqNro, EmpCod, CliCod, LiqNombre FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

