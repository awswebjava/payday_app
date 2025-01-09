package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gananciasdescuentosdeley extends GXProcedure
{
   public gananciasdescuentosdeley( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gananciasdescuentosdeley.class ), "" );
   }

   public gananciasdescuentosdeley( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           boolean aP5 ,
                           java.math.BigDecimal[] aP6 )
   {
      gananciasdescuentosdeley.this.aP7 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        byte[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             byte[] aP7 )
   {
      gananciasdescuentosdeley.this.AV12CliCod = aP0;
      gananciasdescuentosdeley.this.AV13EmpCod = aP1;
      gananciasdescuentosdeley.this.AV15LiqNro = aP2;
      gananciasdescuentosdeley.this.AV14LegNumero = aP3;
      gananciasdescuentosdeley.this.AV34LiqPeriodo = aP4;
      gananciasdescuentosdeley.this.AV33insertandoConceptos = aP5;
      gananciasdescuentosdeley.this.aP6 = aP6;
      gananciasdescuentosdeley.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      AV10descuentos_ConCodigo.clear();
      AV39GXLvl8 = (byte)(0) ;
      /* Using cursor P00QC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV15LiqNro), Integer.valueOf(AV14LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00QC2_A3CliCod[0] ;
         A1EmpCod = P00QC2_A1EmpCod[0] ;
         A6LegNumero = P00QC2_A6LegNumero[0] ;
         A31LiqNro = P00QC2_A31LiqNro[0] ;
         A464DTipoConCod = P00QC2_A464DTipoConCod[0] ;
         A468DSubTipoConCod1 = P00QC2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P00QC2_n468DSubTipoConCod1[0] ;
         A394DConCodigo = P00QC2_A394DConCodigo[0] ;
         A763LiqDRecalculado = P00QC2_A763LiqDRecalculado[0] ;
         A764LiqDImpReCalcu = P00QC2_A764LiqDImpReCalcu[0] ;
         A507LiqDCalculado = P00QC2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P00QC2_A81LiqDSecuencial[0] ;
         AV39GXLvl8 = (byte)(1) ;
         GXv_boolean1[0] = AV27SubTDescuLey ;
         new web.gettipodescuentoley(remoteHandle, context).execute( A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean1) ;
         gananciasdescuentosdeley.this.AV27SubTDescuLey = GXv_boolean1[0] ;
         if ( AV27SubTDescuLey )
         {
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            GXv_int2[0] = AV35auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV12CliCod, A394DConCodigo, AV36ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int2) ;
            gananciasdescuentosdeley.this.AV35auxLiqDCalculado = GXv_int2[0] ;
            if ( AV35auxLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV9importes = AV9importes.add(A764LiqDImpReCalcu) ;
            AV10descuentos_ConCodigo.add(A394DConCodigo, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV39GXLvl8 == 0 )
      {
         if ( AV33insertandoConceptos )
         {
            AV8LiqDCalculado = (byte)(0) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = gananciasdescuentosdeley.this.AV9importes;
      this.aP7[0] = gananciasdescuentosdeley.this.AV8LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9importes = DecimalUtil.ZERO ;
      AV10descuentos_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P00QC2_A3CliCod = new int[1] ;
      P00QC2_A1EmpCod = new short[1] ;
      P00QC2_A6LegNumero = new int[1] ;
      P00QC2_A31LiqNro = new int[1] ;
      P00QC2_A464DTipoConCod = new String[] {""} ;
      P00QC2_A468DSubTipoConCod1 = new String[] {""} ;
      P00QC2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P00QC2_A394DConCodigo = new String[] {""} ;
      P00QC2_A763LiqDRecalculado = new short[1] ;
      P00QC2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QC2_A507LiqDCalculado = new byte[1] ;
      P00QC2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A468DSubTipoConCod1 = "" ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      AV36ProcesoLiquidacion = "" ;
      GXv_int2 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gananciasdescuentosdeley__default(),
         new Object[] {
             new Object[] {
            P00QC2_A3CliCod, P00QC2_A1EmpCod, P00QC2_A6LegNumero, P00QC2_A31LiqNro, P00QC2_A464DTipoConCod, P00QC2_A468DSubTipoConCod1, P00QC2_n468DSubTipoConCod1, P00QC2_A394DConCodigo, P00QC2_A763LiqDRecalculado, P00QC2_A764LiqDImpReCalcu,
            P00QC2_A507LiqDCalculado, P00QC2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV39GXLvl8 ;
   private byte A507LiqDCalculado ;
   private byte AV35auxLiqDCalculado ;
   private byte GXv_int2[] ;
   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15LiqNro ;
   private int AV14LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV9importes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private String AV36ProcesoLiquidacion ;
   private java.util.Date AV34LiqPeriodo ;
   private boolean AV33insertandoConceptos ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV27SubTDescuLey ;
   private boolean GXv_boolean1[] ;
   private boolean returnInSub ;
   private byte[] aP7 ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00QC2_A3CliCod ;
   private short[] P00QC2_A1EmpCod ;
   private int[] P00QC2_A6LegNumero ;
   private int[] P00QC2_A31LiqNro ;
   private String[] P00QC2_A464DTipoConCod ;
   private String[] P00QC2_A468DSubTipoConCod1 ;
   private boolean[] P00QC2_n468DSubTipoConCod1 ;
   private String[] P00QC2_A394DConCodigo ;
   private short[] P00QC2_A763LiqDRecalculado ;
   private java.math.BigDecimal[] P00QC2_A764LiqDImpReCalcu ;
   private byte[] P00QC2_A507LiqDCalculado ;
   private int[] P00QC2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV10descuentos_ConCodigo ;
}

final  class gananciasdescuentosdeley__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QC2", "SELECT CliCod, EmpCod, LegNumero, LiqNro, DTipoConCod, DSubTipoConCod1, DConCodigo, LiqDRecalculado, LiqDImpReCalcu, LiqDCalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( 'DES_ARG') ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod, LiqDCalculado ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
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

