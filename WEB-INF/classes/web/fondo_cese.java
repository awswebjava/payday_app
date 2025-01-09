package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class fondo_cese extends GXProcedure
{
   public fondo_cese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( fondo_cese.class ), "" );
   }

   public fondo_cese( int remoteHandle ,
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
                             java.math.BigDecimal[] aP6 ,
                             byte[] aP7 ,
                             String[] aP8 )
   {
      fondo_cese.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        byte[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             byte[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      fondo_cese.this.AV9CliCod = aP0;
      fondo_cese.this.AV11EmpCod = aP1;
      fondo_cese.this.AV27LiqNro = aP2;
      fondo_cese.this.AV13LegNumero = aP3;
      fondo_cese.this.AV15LiqPeriodo = aP4;
      fondo_cese.this.AV29procesoLiquidacion = aP5;
      fondo_cese.this.aP6 = aP6;
      fondo_cese.this.aP7 = aP7;
      fondo_cese.this.aP8 = aP8;
      fondo_cese.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14LiqDCalculado = (byte)(1) ;
      GXv_boolean1[0] = AV12fondoCeseHay ;
      GXv_boolean2[0] = AV18porPaisEs ;
      GXv_char3[0] = AV10CliConvenio ;
      new web.getmanejafondocese(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV13LegNumero, AV15LiqPeriodo, GXv_boolean1, GXv_boolean2, GXv_char3) ;
      fondo_cese.this.AV12fondoCeseHay = GXv_boolean1[0] ;
      fondo_cese.this.AV18porPaisEs = GXv_boolean2[0] ;
      fondo_cese.this.AV10CliConvenio = GXv_char3[0] ;
      if ( ! AV12fondoCeseHay )
      {
         AV8LiqDLog = httpContext.getMessage( "La configuración indica que no aplican los cálculos de fondo de cese laboral", "") ;
      }
      else
      {
         GXt_int4 = AV16PaiCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int5) ;
         fondo_cese.this.GXt_int4 = GXv_int5[0] ;
         AV16PaiCod = GXt_int4 ;
         if ( AV18porPaisEs )
         {
            AV10CliConvenio = "" ;
            GXv_char3[0] = AV10CliConvenio ;
            GXv_char6[0] = AV26error ;
            new web.getconvenioparafondocese(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, GXv_char3, GXv_char6) ;
            fondo_cese.this.AV10CliConvenio = GXv_char3[0] ;
            fondo_cese.this.AV26error = GXv_char6[0] ;
            if ( ! (GXutil.strcmp("", AV26error)==0) )
            {
               AV14LiqDCalculado = (byte)(0) ;
               AV8LiqDLog = AV26error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( (GXutil.strcmp("", AV10CliConvenio)==0) )
         {
            AV14LiqDCalculado = (byte)(0) ;
            AV26error = httpContext.getMessage( "No se pudo recuperar convenio para definir fondo de cese laboral", "") ;
            AV8LiqDLog = GXutil.trim( AV26error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_date7[0] = AV19CliConveVig ;
         new web.getulticonvevig(remoteHandle, context).execute( AV9CliCod, AV16PaiCod, AV10CliConvenio, AV15LiqPeriodo, GXv_date7) ;
         fondo_cese.this.AV19CliConveVig = GXv_date7[0] ;
         GXv_date7[0] = AV20LegFecIngreso ;
         new web.getfecingreso(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV13LegNumero, GXv_date7) ;
         fondo_cese.this.AV20LegFecIngreso = GXv_date7[0] ;
         AV36hastaFecha = GXutil.eomdate( AV15LiqPeriodo) ;
         GXv_int5[0] = AV21mesesAntiguedad ;
         new web.diferenciameses(remoteHandle, context).execute( AV9CliCod, AV20LegFecIngreso, AV36hastaFecha, (short)(0), GXv_int5) ;
         fondo_cese.this.AV21mesesAntiguedad = GXv_int5[0] ;
         if ( AV21mesesAntiguedad == 0 )
         {
            AV21mesesAntiguedad = (short)(1) ;
         }
         AV39GXLvl36 = (byte)(0) ;
         /* Using cursor P02242 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV16PaiCod), AV10CliConvenio, AV19CliConveVig, Short.valueOf(AV21mesesAntiguedad)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2148CliConveFondoMeses = P02242_A2148CliConveFondoMeses[0] ;
            A1575CliConveVig = P02242_A1575CliConveVig[0] ;
            A1565CliConvenio = P02242_A1565CliConvenio[0] ;
            A1564CliPaiConve = P02242_A1564CliPaiConve[0] ;
            A3CliCod = P02242_A3CliCod[0] ;
            A2150CliConveFondoPrc = P02242_A2150CliConveFondoPrc[0] ;
            A2151CliConveFondoRem = P02242_A2151CliConveFondoRem[0] ;
            A2152CliConveFondoNre = P02242_A2152CliConveFondoNre[0] ;
            A2153CliConveFondoDes = P02242_A2153CliConveFondoDes[0] ;
            A2147CliConveFondoSec = P02242_A2147CliConveFondoSec[0] ;
            AV39GXLvl36 = (byte)(1) ;
            AV22CliConveFondoPrc = A2150CliConveFondoPrc ;
            AV25CliConveFondoRem = A2151CliConveFondoRem ;
            AV24CliConveFondoNre = A2152CliConveFondoNre ;
            AV23CliConveFondoDes = A2153CliConveFondoDes ;
            AV35CliConveFondoMeses = A2148CliConveFondoMeses ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV39GXLvl36 == 0 )
         {
            AV14LiqDCalculado = (byte)(0) ;
            AV26error = httpContext.getMessage( "No se encontró registro según ", "") + GXutil.trim( GXutil.str( AV21mesesAntiguedad, 4, 0)) + httpContext.getMessage( " meses de antiguedad (desde ", "") + GXutil.trim( localUtil.dtoc( AV20LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta ", "") + GXutil.trim( localUtil.dtoc( AV36hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( ") para definir porcentaje de contribución de fondo de cese laboral", "") ;
            AV8LiqDLog = GXutil.trim( AV26error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV22CliConveFondoPrc.doubleValue() == 0 )
         {
            AV14LiqDCalculado = (byte)(0) ;
            AV26error = httpContext.getMessage( "Se recuperó 0% para fondo de cese laboral", "") ;
            AV8LiqDLog = GXutil.trim( AV26error) ;
         }
         else
         {
            if ( (false==AV25CliConveFondoRem) && (false==AV24CliConveFondoNre) )
            {
               AV14LiqDCalculado = (byte)(0) ;
               AV26error = httpContext.getMessage( "Configuración errónea de cálculo de contribución de fondo de cese laboral, debe seleccionarse remunerativos y/o no remunerativos", "") ;
               AV8LiqDLog = GXutil.trim( AV26error) ;
            }
            else
            {
               if ( ( AV25CliConveFondoRem ) && ( AV24CliConveFondoNre ) && ! AV23CliConveFondoDes )
               {
                  GXv_char6[0] = AV28sueldoBrutoConCodigo ;
                  new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.concepto_sueldobruto_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
                  fondo_cese.this.AV28sueldoBrutoConCodigo = GXv_char6[0] ;
                  GXv_decimal8[0] = AV31LiqDImpCalcu ;
                  GXv_boolean2[0] = false ;
                  GXv_int9[0] = AV30auxLiqDCalculado ;
                  new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV27LiqNro, AV13LegNumero, AV28sueldoBrutoConCodigo, AV29procesoLiquidacion, false, GXv_decimal8, GXv_boolean2, GXv_int9) ;
                  fondo_cese.this.AV31LiqDImpCalcu = GXv_decimal8[0] ;
                  fondo_cese.this.AV30auxLiqDCalculado = GXv_int9[0] ;
                  if ( AV30auxLiqDCalculado == 0 )
                  {
                     AV14LiqDCalculado = (byte)(0) ;
                     AV26error = httpContext.getMessage( "Falta calcular concepto Sueldo bruto", "") ;
                     AV8LiqDLog = GXutil.trim( AV26error) ;
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV8LiqDLog = httpContext.getMessage( "Se inicializa valor con sueldo bruto ", "") + GXutil.trim( GXutil.str( AV31LiqDImpCalcu, 14, 2)) ;
               }
               else
               {
                  if ( AV25CliConveFondoRem )
                  {
                     GXv_char6[0] = AV32TipoConCod ;
                     new web.gettipoconcepto(remoteHandle, context).execute( AV16PaiCod, "REM", GXv_char6) ;
                     fondo_cese.this.AV32TipoConCod = GXv_char6[0] ;
                     GXv_decimal8[0] = AV34auxLiqDImpCalcu ;
                     GXv_int9[0] = AV30auxLiqDCalculado ;
                     new web.getimpliqportipo(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV27LiqNro, AV13LegNumero, AV15LiqPeriodo, AV32TipoConCod, "", AV29procesoLiquidacion, AV33excluirConCodigo, GXv_decimal8, GXv_int9) ;
                     fondo_cese.this.AV34auxLiqDImpCalcu = GXv_decimal8[0] ;
                     fondo_cese.this.AV30auxLiqDCalculado = GXv_int9[0] ;
                     if ( AV30auxLiqDCalculado == 0 )
                     {
                        AV14LiqDCalculado = (byte)(0) ;
                        AV26error = httpContext.getMessage( "Falta calcular conceptos remunerativos", "") ;
                        AV8LiqDLog = GXutil.trim( AV26error) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV31LiqDImpCalcu = AV34auxLiqDImpCalcu ;
                     AV8LiqDLog = httpContext.getMessage( "Se inicializa valor con importes remunerativos ", "") + GXutil.trim( GXutil.str( AV34auxLiqDImpCalcu, 14, 2)) ;
                  }
                  if ( AV24CliConveFondoNre )
                  {
                     GXv_char6[0] = AV32TipoConCod ;
                     new web.gettipoconcepto(remoteHandle, context).execute( AV16PaiCod, "NRE", GXv_char6) ;
                     fondo_cese.this.AV32TipoConCod = GXv_char6[0] ;
                     GXv_decimal8[0] = AV34auxLiqDImpCalcu ;
                     GXv_int9[0] = AV30auxLiqDCalculado ;
                     new web.getimpliqportipo(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV27LiqNro, AV13LegNumero, AV15LiqPeriodo, AV32TipoConCod, "", AV29procesoLiquidacion, AV33excluirConCodigo, GXv_decimal8, GXv_int9) ;
                     fondo_cese.this.AV34auxLiqDImpCalcu = GXv_decimal8[0] ;
                     fondo_cese.this.AV30auxLiqDCalculado = GXv_int9[0] ;
                     if ( AV30auxLiqDCalculado == 0 )
                     {
                        AV14LiqDCalculado = (byte)(0) ;
                        AV26error = httpContext.getMessage( "Falta calcular conceptos no remunerativos", "") ;
                        AV8LiqDLog = GXutil.trim( AV26error) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV31LiqDImpCalcu = AV31LiqDImpCalcu.add(AV34auxLiqDImpCalcu) ;
                     if ( (GXutil.strcmp("", AV8LiqDLog)==0) )
                     {
                        AV8LiqDLog = httpContext.getMessage( "Se inicializa valor con importes no remunerativos ", "") + GXutil.trim( GXutil.str( AV34auxLiqDImpCalcu, 14, 2)) ;
                     }
                     else
                     {
                        if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34auxLiqDImpCalcu)==0) )
                        {
                           AV8LiqDLog += httpContext.getMessage( ". Se suman importes no remunerativos por ", "") + GXutil.trim( GXutil.str( AV34auxLiqDImpCalcu, 14, 2)) ;
                        }
                     }
                  }
                  if ( AV23CliConveFondoDes )
                  {
                     GXv_char6[0] = AV32TipoConCod ;
                     new web.gettipoconcepto(remoteHandle, context).execute( AV16PaiCod, "DES", GXv_char6) ;
                     fondo_cese.this.AV32TipoConCod = GXv_char6[0] ;
                     GXv_decimal8[0] = AV34auxLiqDImpCalcu ;
                     GXv_int9[0] = AV30auxLiqDCalculado ;
                     new web.getimpliqportipo(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV27LiqNro, AV13LegNumero, AV15LiqPeriodo, AV32TipoConCod, "", AV29procesoLiquidacion, AV33excluirConCodigo, GXv_decimal8, GXv_int9) ;
                     fondo_cese.this.AV34auxLiqDImpCalcu = GXv_decimal8[0] ;
                     fondo_cese.this.AV30auxLiqDCalculado = GXv_int9[0] ;
                     if ( AV30auxLiqDCalculado == 0 )
                     {
                        AV14LiqDCalculado = (byte)(0) ;
                        AV26error = httpContext.getMessage( "Falta calcular conceptos de descuento", "") ;
                        AV8LiqDLog = GXutil.trim( AV26error) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV31LiqDImpCalcu = AV31LiqDImpCalcu.subtract(AV34auxLiqDImpCalcu) ;
                     if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34auxLiqDImpCalcu)==0) )
                     {
                        AV8LiqDLog += httpContext.getMessage( ". Se restan importes de descuento por ", "") + GXutil.trim( GXutil.str( AV34auxLiqDImpCalcu, 14, 2)) ;
                     }
                  }
               }
               AV8LiqDLog += httpContext.getMessage( ". Legajo con ", "") + GXutil.trim( GXutil.str( AV21mesesAntiguedad, 4, 0)) + httpContext.getMessage( " meses de antiguedad", "") ;
               AV31LiqDImpCalcu = AV31LiqDImpCalcu.multiply(AV22CliConveFondoPrc) ;
               AV8LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV22CliConveFondoPrc, 6, 4)) ;
               AV8LiqDLog += httpContext.getMessage( " definido en convenio", "") ;
               if ( AV35CliConveFondoMeses > 0 )
               {
                  AV8LiqDLog += httpContext.getMessage( " a partir de los ", "") + GXutil.str( AV35CliConveFondoMeses, 4, 0) + httpContext.getMessage( " de antiguedad", "") ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = fondo_cese.this.AV31LiqDImpCalcu;
      this.aP7[0] = fondo_cese.this.AV14LiqDCalculado;
      this.aP8[0] = fondo_cese.this.AV8LiqDLog;
      this.aP9[0] = fondo_cese.this.AV26error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31LiqDImpCalcu = DecimalUtil.ZERO ;
      AV8LiqDLog = "" ;
      AV26error = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV10CliConvenio = "" ;
      GXv_char3 = new String[1] ;
      AV19CliConveVig = GXutil.nullDate() ;
      AV20LegFecIngreso = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV36hastaFecha = GXutil.nullDate() ;
      GXv_int5 = new short[1] ;
      scmdbuf = "" ;
      P02242_A2148CliConveFondoMeses = new short[1] ;
      P02242_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02242_A1565CliConvenio = new String[] {""} ;
      P02242_A1564CliPaiConve = new short[1] ;
      P02242_A3CliCod = new int[1] ;
      P02242_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02242_A2151CliConveFondoRem = new boolean[] {false} ;
      P02242_A2152CliConveFondoNre = new boolean[] {false} ;
      P02242_A2153CliConveFondoDes = new boolean[] {false} ;
      P02242_A2147CliConveFondoSec = new short[1] ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1565CliConvenio = "" ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      AV22CliConveFondoPrc = DecimalUtil.ZERO ;
      AV28sueldoBrutoConCodigo = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV32TipoConCod = "" ;
      AV33excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_char6 = new String[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_int9 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.fondo_cese__default(),
         new Object[] {
             new Object[] {
            P02242_A2148CliConveFondoMeses, P02242_A1575CliConveVig, P02242_A1565CliConvenio, P02242_A1564CliPaiConve, P02242_A3CliCod, P02242_A2150CliConveFondoPrc, P02242_A2151CliConveFondoRem, P02242_A2152CliConveFondoNre, P02242_A2153CliConveFondoDes, P02242_A2147CliConveFondoSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqDCalculado ;
   private byte AV39GXLvl36 ;
   private byte AV30auxLiqDCalculado ;
   private byte GXv_int9[] ;
   private short AV11EmpCod ;
   private short AV16PaiCod ;
   private short GXt_int4 ;
   private short AV21mesesAntiguedad ;
   private short GXv_int5[] ;
   private short A2148CliConveFondoMeses ;
   private short A1564CliPaiConve ;
   private short A2147CliConveFondoSec ;
   private short AV35CliConveFondoMeses ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV27LiqNro ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV31LiqDImpCalcu ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private java.math.BigDecimal AV22CliConveFondoPrc ;
   private java.math.BigDecimal AV34auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV29procesoLiquidacion ;
   private String AV10CliConvenio ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV28sueldoBrutoConCodigo ;
   private String AV32TipoConCod ;
   private String GXv_char6[] ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date AV19CliConveVig ;
   private java.util.Date AV20LegFecIngreso ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV36hastaFecha ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV12fondoCeseHay ;
   private boolean GXv_boolean1[] ;
   private boolean AV18porPaisEs ;
   private boolean returnInSub ;
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private boolean AV25CliConveFondoRem ;
   private boolean AV24CliConveFondoNre ;
   private boolean AV23CliConveFondoDes ;
   private boolean GXv_boolean2[] ;
   private String AV8LiqDLog ;
   private String AV26error ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private byte[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private short[] P02242_A2148CliConveFondoMeses ;
   private java.util.Date[] P02242_A1575CliConveVig ;
   private String[] P02242_A1565CliConvenio ;
   private short[] P02242_A1564CliPaiConve ;
   private int[] P02242_A3CliCod ;
   private java.math.BigDecimal[] P02242_A2150CliConveFondoPrc ;
   private boolean[] P02242_A2151CliConveFondoRem ;
   private boolean[] P02242_A2152CliConveFondoNre ;
   private boolean[] P02242_A2153CliConveFondoDes ;
   private short[] P02242_A2147CliConveFondoSec ;
   private GXSimpleCollection<String> AV33excluirConCodigo ;
}

final  class fondo_cese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02242", "SELECT CliConveFondoMeses, CliConveVig, CliConvenio, CliPaiConve, CliCod, CliConveFondoPrc, CliConveFondoRem, CliConveFondoNre, CliConveFondoDes, CliConveFondoSec FROM Clientecct_fondocese WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ?) AND (CliConveFondoMeses < ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoMeses  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

