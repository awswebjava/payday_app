package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deducciones_generales_anuales extends GXProcedure
{
   public deducciones_generales_anuales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deducciones_generales_anuales.class ), "" );
   }

   public deducciones_generales_anuales( int remoteHandle ,
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
      deducciones_generales_anuales.this.aP10 = new String[] {""};
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
      deducciones_generales_anuales.this.AV8CliCod = aP0;
      deducciones_generales_anuales.this.AV9EmpCod = aP1;
      deducciones_generales_anuales.this.AV10LiqNro = aP2;
      deducciones_generales_anuales.this.AV11LegNumero = aP3;
      deducciones_generales_anuales.this.AV12LiqPeriodo = aP4;
      deducciones_generales_anuales.this.AV18TLiqCod = aP5;
      deducciones_generales_anuales.this.AV13ProcesoLiquidacion = aP6;
      deducciones_generales_anuales.this.aP7 = aP7;
      deducciones_generales_anuales.this.aP8 = aP8;
      deducciones_generales_anuales.this.aP9 = aP9;
      deducciones_generales_anuales.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV19sacTLiqCod ;
      GXt_char2 = AV19sacTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      deducciones_generales_anuales.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      deducciones_generales_anuales.this.GXt_char1 = GXv_char4[0] ;
      AV19sacTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV18TLiqCod, AV19sacTLiqCod) == 0 )
      {
         AV15LiqDLog = httpContext.getMessage( "No se calcula por ser liquidación de SAC", "") ;
      }
      else
      {
         GXt_char2 = AV20SubTipoConCod1 ;
         GXv_char4[0] = GXt_char2 ;
         new web.subtipoganancias(remoteHandle, context).execute( GXv_char4) ;
         deducciones_generales_anuales.this.GXt_char2 = GXv_char4[0] ;
         AV20SubTipoConCod1 = GXt_char2 ;
         GXt_char2 = AV21SubTipoConCod2 ;
         GXv_char4[0] = GXt_char2 ;
         new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).execute( GXv_char4) ;
         deducciones_generales_anuales.this.GXt_char2 = GXv_char4[0] ;
         AV21SubTipoConCod2 = GXt_char2 ;
         /* Using cursor P026O2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV21SubTipoConCod2, AV20SubTipoConCod1});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A39SubTipoConCod2 = P026O2_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = P026O2_n39SubTipoConCod2[0] ;
            A38SubTipoConCod1 = P026O2_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P026O2_n38SubTipoConCod1[0] ;
            A3CliCod = P026O2_A3CliCod[0] ;
            A26ConCodigo = P026O2_A26ConCodigo[0] ;
            AV24auxConCodigo = A26ConCodigo ;
            GXv_decimal5[0] = AV27auxLiqDImpCalcu ;
            GXv_boolean6[0] = AV28existe ;
            GXv_int7[0] = AV25auxLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV24auxConCodigo, AV13ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
            deducciones_generales_anuales.this.AV27auxLiqDImpCalcu = GXv_decimal5[0] ;
            deducciones_generales_anuales.this.AV28existe = GXv_boolean6[0] ;
            deducciones_generales_anuales.this.AV25auxLiqDCalculado = GXv_int7[0] ;
            GXv_char4[0] = AV26ConDescrip ;
            new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV24auxConCodigo, GXv_char4) ;
            deducciones_generales_anuales.this.AV26ConDescrip = GXv_char4[0] ;
            if ( AV25auxLiqDCalculado == 0 )
            {
               AV17error = httpContext.getMessage( "Falta calcular concepto \"", "") + GXutil.trim( AV26ConDescrip) + "\"" ;
               AV15LiqDLog = GXutil.trim( AV17error) ;
               AV16LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV27auxLiqDImpCalcu)==0) )
            {
               AV14Importes = AV14Importes.add(AV27auxLiqDImpCalcu) ;
               if ( ! (GXutil.strcmp("", AV15LiqDLog)==0) )
               {
                  AV15LiqDLog += ". " ;
               }
               AV15LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV27auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV26ConDescrip) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV14Importes)==0) )
         {
            AV15LiqDLog = httpContext.getMessage( "No existen deducciones generales anuales al momento de la liquidación", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = deducciones_generales_anuales.this.AV14Importes;
      this.aP8[0] = deducciones_generales_anuales.this.AV15LiqDLog;
      this.aP9[0] = deducciones_generales_anuales.this.AV16LiqDCalculado;
      this.aP10[0] = deducciones_generales_anuales.this.AV17error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Importes = DecimalUtil.ZERO ;
      AV15LiqDLog = "" ;
      AV17error = "" ;
      AV19sacTLiqCod = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV20SubTipoConCod1 = "" ;
      AV21SubTipoConCod2 = "" ;
      GXt_char2 = "" ;
      scmdbuf = "" ;
      P026O2_A39SubTipoConCod2 = new String[] {""} ;
      P026O2_n39SubTipoConCod2 = new boolean[] {false} ;
      P026O2_A38SubTipoConCod1 = new String[] {""} ;
      P026O2_n38SubTipoConCod1 = new boolean[] {false} ;
      P026O2_A3CliCod = new int[1] ;
      P026O2_A26ConCodigo = new String[] {""} ;
      A39SubTipoConCod2 = "" ;
      A38SubTipoConCod1 = "" ;
      A26ConCodigo = "" ;
      AV24auxConCodigo = "" ;
      AV27auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV26ConDescrip = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deducciones_generales_anuales__default(),
         new Object[] {
             new Object[] {
            P026O2_A39SubTipoConCod2, P026O2_n39SubTipoConCod2, P026O2_A38SubTipoConCod1, P026O2_n38SubTipoConCod1, P026O2_A3CliCod, P026O2_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqDCalculado ;
   private byte AV25auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV14Importes ;
   private java.math.BigDecimal AV27auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV18TLiqCod ;
   private String AV13ProcesoLiquidacion ;
   private String AV19sacTLiqCod ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV20SubTipoConCod1 ;
   private String AV21SubTipoConCod2 ;
   private String GXt_char2 ;
   private String scmdbuf ;
   private String A39SubTipoConCod2 ;
   private String A38SubTipoConCod1 ;
   private String A26ConCodigo ;
   private String AV24auxConCodigo ;
   private String GXv_char4[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean n39SubTipoConCod2 ;
   private boolean n38SubTipoConCod1 ;
   private boolean AV28existe ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private String AV15LiqDLog ;
   private String AV17error ;
   private String AV26ConDescrip ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P026O2_A39SubTipoConCod2 ;
   private boolean[] P026O2_n39SubTipoConCod2 ;
   private String[] P026O2_A38SubTipoConCod1 ;
   private boolean[] P026O2_n38SubTipoConCod1 ;
   private int[] P026O2_A3CliCod ;
   private String[] P026O2_A26ConCodigo ;
}

final  class deducciones_generales_anuales__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026O2", "SELECT SubTipoConCod2, SubTipoConCod1, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and SubTipoConCod2 = ( ?)) AND (SubTipoConCod1 = ( ?)) ORDER BY CliCod, SubTipoConCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

