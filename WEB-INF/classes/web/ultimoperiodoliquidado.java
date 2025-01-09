package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ultimoperiodoliquidado extends GXProcedure
{
   public ultimoperiodoliquidado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ultimoperiodoliquidado.class ), "" );
   }

   public ultimoperiodoliquidado( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 )
   {
      ultimoperiodoliquidado.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 ,
                             String[] aP4 )
   {
      ultimoperiodoliquidado.this.AV10CliCod = aP0;
      ultimoperiodoliquidado.this.AV9EmpCod = aP1;
      ultimoperiodoliquidado.this.AV11LegNumero = aP2;
      ultimoperiodoliquidado.this.aP3 = aP3;
      ultimoperiodoliquidado.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV14egresoTLiqCod ;
      GXt_char2 = AV14egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      ultimoperiodoliquidado.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      ultimoperiodoliquidado.this.GXt_char1 = GXv_char4[0] ;
      AV14egresoTLiqCod = GXt_char1 ;
      /* Using cursor P00SF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero), AV14egresoTLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00SF2_A3CliCod[0] ;
         A1EmpCod = P00SF2_A1EmpCod[0] ;
         A6LegNumero = P00SF2_A6LegNumero[0] ;
         A32TLiqCod = P00SF2_A32TLiqCod[0] ;
         n32TLiqCod = P00SF2_n32TLiqCod[0] ;
         A31LiqNro = P00SF2_A31LiqNro[0] ;
         A283LiqPeriodo = P00SF2_A283LiqPeriodo[0] ;
         AV12LiqPeriodo = A283LiqPeriodo ;
         AV13TLiqCod = A32TLiqCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = ultimoperiodoliquidado.this.AV12LiqPeriodo;
      this.aP4[0] = ultimoperiodoliquidado.this.AV13TLiqCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqPeriodo = GXutil.nullDate() ;
      AV13TLiqCod = "" ;
      AV14egresoTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P00SF2_A3CliCod = new int[1] ;
      P00SF2_A1EmpCod = new short[1] ;
      P00SF2_A6LegNumero = new int[1] ;
      P00SF2_A32TLiqCod = new String[] {""} ;
      P00SF2_n32TLiqCod = new boolean[] {false} ;
      P00SF2_A31LiqNro = new int[1] ;
      P00SF2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ultimoperiodoliquidado__default(),
         new Object[] {
             new Object[] {
            P00SF2_A3CliCod, P00SF2_A1EmpCod, P00SF2_A6LegNumero, P00SF2_A32TLiqCod, P00SF2_n32TLiqCod, P00SF2_A31LiqNro, P00SF2_A283LiqPeriodo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private String AV13TLiqCod ;
   private String AV14egresoTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n32TLiqCod ;
   private String[] aP4 ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00SF2_A3CliCod ;
   private short[] P00SF2_A1EmpCod ;
   private int[] P00SF2_A6LegNumero ;
   private String[] P00SF2_A32TLiqCod ;
   private boolean[] P00SF2_n32TLiqCod ;
   private int[] P00SF2_A31LiqNro ;
   private java.util.Date[] P00SF2_A283LiqPeriodo ;
}

final  class ultimoperiodoliquidado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SF2", "SELECT CliCod, EmpCod, LegNumero, TLiqCod, LiqNro, LiqPeriodo FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (TLiqCod <> ( ?)) ORDER BY CliCod, EmpCod, LegNumero, LiqPeriodo DESC, LiqNro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

