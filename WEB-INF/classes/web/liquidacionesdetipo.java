package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionesdetipo extends GXProcedure
{
   public liquidacionesdetipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionesdetipo.class ), "" );
   }

   public liquidacionesdetipo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      liquidacionesdetipo.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      liquidacionesdetipo.this.AV10CliCod = aP0;
      liquidacionesdetipo.this.AV8EmpCod = aP1;
      liquidacionesdetipo.this.AV9LiqNro = aP2;
      liquidacionesdetipo.this.AV11TLiqCod = aP3;
      liquidacionesdetipo.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13esDeTipo = "0" ;
      /* Using cursor P00IJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00IJ2_A31LiqNro[0] ;
         A1EmpCod = P00IJ2_A1EmpCod[0] ;
         A3CliCod = P00IJ2_A3CliCod[0] ;
         A32TLiqCod = P00IJ2_A32TLiqCod[0] ;
         n32TLiqCod = P00IJ2_n32TLiqCod[0] ;
         if ( GXutil.strcmp(A32TLiqCod, AV11TLiqCod) == 0 )
         {
            AV13esDeTipo = "1" ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = liquidacionesdetipo.this.AV13esDeTipo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13esDeTipo = "" ;
      scmdbuf = "" ;
      P00IJ2_A31LiqNro = new int[1] ;
      P00IJ2_A1EmpCod = new short[1] ;
      P00IJ2_A3CliCod = new int[1] ;
      P00IJ2_A32TLiqCod = new String[] {""} ;
      P00IJ2_n32TLiqCod = new boolean[] {false} ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionesdetipo__default(),
         new Object[] {
             new Object[] {
            P00IJ2_A31LiqNro, P00IJ2_A1EmpCod, P00IJ2_A3CliCod, P00IJ2_A32TLiqCod, P00IJ2_n32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV11TLiqCod ;
   private String AV13esDeTipo ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private boolean n32TLiqCod ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00IJ2_A31LiqNro ;
   private short[] P00IJ2_A1EmpCod ;
   private int[] P00IJ2_A3CliCod ;
   private String[] P00IJ2_A32TLiqCod ;
   private boolean[] P00IJ2_n32TLiqCod ;
}

final  class liquidacionesdetipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IJ2", "SELECT LiqNro, EmpCod, CliCod, TLiqCod FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

