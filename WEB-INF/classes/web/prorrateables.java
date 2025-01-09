package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prorrateables extends GXProcedure
{
   public prorrateables( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prorrateables.class ), "" );
   }

   public prorrateables( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 )
   {
      prorrateables.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      prorrateables.this.AV15CliCod = aP0;
      prorrateables.this.AV14EmpCod = aP1;
      prorrateables.this.AV16LiqNro = aP2;
      prorrateables.this.AV17LegNumero = aP3;
      prorrateables.this.AV12LiqPeriodo = aP4;
      prorrateables.this.AV21ConCodigo = aP5;
      prorrateables.this.AV22ProcesoLiquidacion = aP6;
      prorrateables.this.aP7 = aP7;
      prorrateables.this.aP8 = aP8;
      prorrateables.this.aP9 = aP9;
      prorrateables.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9TLiqCod ;
      GXv_char2[0] = GXt_char1 ;
      new web.gettipoliq(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, AV16LiqNro, GXv_char2) ;
      prorrateables.this.GXt_char1 = GXv_char2[0] ;
      AV9TLiqCod = GXt_char1 ;
      GXt_char1 = AV10egresoTLiqCod ;
      GXt_char3 = AV10egresoTLiqCod ;
      GXv_char2[0] = GXt_char3 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      prorrateables.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char3, GXv_char4) ;
      prorrateables.this.GXt_char1 = GXv_char4[0] ;
      AV10egresoTLiqCod = GXt_char1 ;
      GXt_char3 = AV11mensualTLiqCod ;
      GXt_char1 = AV11mensualTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      prorrateables.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char2) ;
      prorrateables.this.GXt_char3 = GXv_char2[0] ;
      AV11mensualTLiqCod = GXt_char3 ;
      if ( ( ( GXutil.month( AV12LiqPeriodo) == 12 ) && ( GXutil.strcmp(AV9TLiqCod, AV11mensualTLiqCod) == 0 ) ) || ( GXutil.strcmp(AV9TLiqCod, AV10egresoTLiqCod) == 0 ) )
      {
         AV13Importes = DecimalUtil.doubleToDec(0) ;
      }
      else
      {
         GXv_char4[0] = AV28exentoConCodigo ;
         new web.getapliiggexencon(remoteHandle, context).execute( AV15CliCod, AV27principalAplIIGG, GXv_char4) ;
         prorrateables.this.AV28exentoConCodigo = GXv_char4[0] ;
         /* Using cursor P017E2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV16LiqNro), Integer.valueOf(AV17LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1125LiqDProrr = P017E2_A1125LiqDProrr[0] ;
            A6LegNumero = P017E2_A6LegNumero[0] ;
            A31LiqNro = P017E2_A31LiqNro[0] ;
            A1EmpCod = P017E2_A1EmpCod[0] ;
            A3CliCod = P017E2_A3CliCod[0] ;
            A764LiqDImpReCalcu = P017E2_A764LiqDImpReCalcu[0] ;
            A394DConCodigo = P017E2_A394DConCodigo[0] ;
            A507LiqDCalculado = P017E2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P017E2_A763LiqDRecalculado[0] ;
            A81LiqDSecuencial = P017E2_A81LiqDSecuencial[0] ;
            AV13Importes = AV13Importes.add(A764LiqDImpReCalcu) ;
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            if ( ( new web.dependenciaresuelta2(remoteHandle, context).executeUdp( AV15CliCod, A394DConCodigo, AV22ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado) == ( 0 )) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV18error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A394DConCodigo) ;
               AV8LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "llama a calcularExento", "")) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = prorrateables.this.AV13Importes;
      this.aP8[0] = prorrateables.this.AV18error;
      this.aP9[0] = prorrateables.this.AV8LiqDCalculado;
      this.aP10[0] = prorrateables.this.AV19LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Importes = DecimalUtil.ZERO ;
      AV18error = "" ;
      AV19LiqDLog = "" ;
      AV9TLiqCod = "" ;
      AV10egresoTLiqCod = "" ;
      AV11mensualTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV28exentoConCodigo = "" ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P017E2_A1125LiqDProrr = new String[] {""} ;
      P017E2_A6LegNumero = new int[1] ;
      P017E2_A31LiqNro = new int[1] ;
      P017E2_A1EmpCod = new short[1] ;
      P017E2_A3CliCod = new int[1] ;
      P017E2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017E2_A394DConCodigo = new String[] {""} ;
      P017E2_A507LiqDCalculado = new byte[1] ;
      P017E2_A763LiqDRecalculado = new short[1] ;
      P017E2_A81LiqDSecuencial = new int[1] ;
      A1125LiqDProrr = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      AV32Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.prorrateables__default(),
         new Object[] {
             new Object[] {
            P017E2_A1125LiqDProrr, P017E2_A6LegNumero, P017E2_A31LiqNro, P017E2_A1EmpCod, P017E2_A3CliCod, P017E2_A764LiqDImpReCalcu, P017E2_A394DConCodigo, P017E2_A507LiqDCalculado, P017E2_A763LiqDRecalculado, P017E2_A81LiqDSecuencial
            }
         }
      );
      AV32Pgmname = "prorrateables" ;
      /* GeneXus formulas. */
      AV32Pgmname = "prorrateables" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private short AV14EmpCod ;
   private short AV27principalAplIIGG ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV16LiqNro ;
   private int AV17LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV13Importes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV21ConCodigo ;
   private String AV22ProcesoLiquidacion ;
   private String AV9TLiqCod ;
   private String AV10egresoTLiqCod ;
   private String AV11mensualTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV28exentoConCodigo ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A1125LiqDProrr ;
   private String A394DConCodigo ;
   private String AV32Pgmname ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV19LiqDLog ;
   private String AV18error ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P017E2_A1125LiqDProrr ;
   private int[] P017E2_A6LegNumero ;
   private int[] P017E2_A31LiqNro ;
   private short[] P017E2_A1EmpCod ;
   private int[] P017E2_A3CliCod ;
   private java.math.BigDecimal[] P017E2_A764LiqDImpReCalcu ;
   private String[] P017E2_A394DConCodigo ;
   private byte[] P017E2_A507LiqDCalculado ;
   private short[] P017E2_A763LiqDRecalculado ;
   private int[] P017E2_A81LiqDSecuencial ;
}

final  class prorrateables__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017E2", "SELECT LiqDProrr, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, DConCodigo, LiqDCalculado, LiqDRecalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqDProrr = ( 'FIJA')) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

