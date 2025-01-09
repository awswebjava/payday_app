package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class basecalculo_obligacion extends GXProcedure
{
   public basecalculo_obligacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( basecalculo_obligacion.class ), "" );
   }

   public basecalculo_obligacion( int remoteHandle ,
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
                           short aP5 ,
                           String aP6 ,
                           String aP7 ,
                           boolean aP8 ,
                           short aP9 ,
                           java.math.BigDecimal[] aP10 ,
                           String[] aP11 ,
                           String[] aP12 )
   {
      basecalculo_obligacion.this.aP13 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        short aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        byte[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             short aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 )
   {
      basecalculo_obligacion.this.AV16CliCod = aP0;
      basecalculo_obligacion.this.AV9EmpCod = aP1;
      basecalculo_obligacion.this.AV18LiqNro = aP2;
      basecalculo_obligacion.this.AV10LegNumero = aP3;
      basecalculo_obligacion.this.AV11LiqPeriodo = aP4;
      basecalculo_obligacion.this.AV44OblSecuencial = aP5;
      basecalculo_obligacion.this.AV12ConCodigo = aP6;
      basecalculo_obligacion.this.AV19ProcesoLiquidacion = aP7;
      basecalculo_obligacion.this.AV13insertandoConceptos = aP8;
      basecalculo_obligacion.this.AV42PaiCod = aP9;
      basecalculo_obligacion.this.aP10 = aP10;
      basecalculo_obligacion.this.aP11 = aP11;
      basecalculo_obligacion.this.aP12 = aP12;
      basecalculo_obligacion.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "1") ;
      /* Using cursor P019L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV44OblSecuencial)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1172OblSecuencial = P019L2_A1172OblSecuencial[0] ;
         A6LegNumero = P019L2_A6LegNumero[0] ;
         A1EmpCod = P019L2_A1EmpCod[0] ;
         A3CliCod = P019L2_A3CliCod[0] ;
         A1181OblNoRemu = P019L2_A1181OblNoRemu[0] ;
         A1182OblDescu = P019L2_A1182OblDescu[0] ;
         AV20OblNoRemu = A1181OblNoRemu ;
         AV28OblDescu = A1182OblDescu ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P019L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV44OblSecuencial)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1172OblSecuencial = P019L3_A1172OblSecuencial[0] ;
         A6LegNumero = P019L3_A6LegNumero[0] ;
         A1EmpCod = P019L3_A1EmpCod[0] ;
         A3CliCod = P019L3_A3CliCod[0] ;
         A1170OblExcConCOdigo = P019L3_A1170OblExcConCOdigo[0] ;
         A1183OblExcTipo = P019L3_A1183OblExcTipo[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "2") ;
         GXv_char1[0] = AV17TipoConCod ;
         new web.conceptogettipo(remoteHandle, context).execute( AV16CliCod, A1170OblExcConCOdigo, GXv_char1) ;
         basecalculo_obligacion.this.AV17TipoConCod = GXv_char1[0] ;
         if ( GXutil.strcmp(A1183OblExcTipo, httpContext.getMessage( "E", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "3") ;
            if ( GXutil.strcmp(AV17TipoConCod, "REM_ARG") == 0 )
            {
               AV14excluirRemunConCodigo.add(A1170OblExcConCOdigo, 0);
            }
            if ( GXutil.strcmp(AV17TipoConCod, "NRE_ARG") == 0 )
            {
               AV21excluirNoRemunConCodigo.add(A1170OblExcConCOdigo, 0);
            }
            if ( GXutil.strcmp(AV17TipoConCod, "DES_ARG") == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "4") ;
               AV29excluiDescuConCodigo.add(A1170OblExcConCOdigo, 0);
            }
         }
         else
         {
            if ( GXutil.strcmp(AV17TipoConCod, "NRE_ARG") == 0 )
            {
               AV36incluirNoRemuConCodigo.add(A1170OblExcConCOdigo, 0);
            }
            if ( GXutil.strcmp(AV17TipoConCod, "DES_ARG") == 0 )
            {
               AV39incluirDescuConCodigo.add(A1170OblExcConCOdigo, 0);
            }
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "5") ;
      GXv_decimal2[0] = AV22remunerativosLiqDImpCalcu ;
      GXv_int3[0] = AV23remuLiqDCalculado ;
      new web.getimpliqportipo(remoteHandle, context).execute( AV16CliCod, AV9EmpCod, AV18LiqNro, AV10LegNumero, AV11LiqPeriodo, "REM_ARG", AV12ConCodigo, AV19ProcesoLiquidacion, AV14excluirRemunConCodigo, GXv_decimal2, GXv_int3) ;
      basecalculo_obligacion.this.AV22remunerativosLiqDImpCalcu = GXv_decimal2[0] ;
      basecalculo_obligacion.this.AV23remuLiqDCalculado = GXv_int3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "6") ;
      if ( AV23remuLiqDCalculado == 0 )
      {
         AV24LiqDCalculado = (byte)(0) ;
         AV25error = httpContext.getMessage( "Falta calcular conceptos remunerativos", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         AV34Importes = AV22remunerativosLiqDImpCalcu ;
         AV32LiqDLog = httpContext.getMessage( "Para la base de calculo del porcentaje se inicializa valor con ", "") + GXutil.trim( GXutil.str( AV22remunerativosLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de conceptos remunerativos", "") ;
         if ( AV14excluirRemunConCodigo.size() > 0 )
         {
            AV33excluidosStr = GXutil.strReplace( AV14excluirRemunConCodigo.toJSonString(false), "[", "") ;
            AV33excluidosStr = GXutil.strReplace( AV33excluidosStr, "]", "") ;
            if ( AV14excluirRemunConCodigo.size() > 1 )
            {
               AV32LiqDLog += httpContext.getMessage( " (excepto los conceptos excluidos ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
            }
            else
            {
               AV32LiqDLog += httpContext.getMessage( " (excepto el concepto excluido ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
            }
         }
      }
      if ( AV20OblNoRemu )
      {
         GXv_decimal2[0] = AV26noRemuLiqDImpCalcu ;
         GXv_int3[0] = AV27noRemuLiqDCalculado ;
         new web.getimpliqportipo(remoteHandle, context).execute( AV16CliCod, AV9EmpCod, AV18LiqNro, AV10LegNumero, AV11LiqPeriodo, "NRE_ARG", AV12ConCodigo, AV19ProcesoLiquidacion, AV21excluirNoRemunConCodigo, GXv_decimal2, GXv_int3) ;
         basecalculo_obligacion.this.AV26noRemuLiqDImpCalcu = GXv_decimal2[0] ;
         basecalculo_obligacion.this.AV27noRemuLiqDCalculado = GXv_int3[0] ;
         if ( AV27noRemuLiqDCalculado == 0 )
         {
            AV24LiqDCalculado = (byte)(0) ;
            AV25error = httpContext.getMessage( "Falta calcular conceptos no remunerativos", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV34Importes = AV34Importes.add(AV26noRemuLiqDImpCalcu) ;
            AV32LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV26noRemuLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de conceptos no remunerativos", "") ;
            if ( AV21excluirNoRemunConCodigo.size() > 0 )
            {
               AV33excluidosStr = GXutil.strReplace( AV21excluirNoRemunConCodigo.toJSonString(false), "[", "") ;
               AV33excluidosStr = GXutil.strReplace( AV33excluidosStr, "]", "") ;
               if ( AV21excluirNoRemunConCodigo.size() > 1 )
               {
                  AV32LiqDLog += httpContext.getMessage( " (excepto los conceptos excluidos ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
               }
               else
               {
                  AV32LiqDLog += httpContext.getMessage( " (excepto el concepto excluido ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
               }
            }
         }
      }
      else
      {
         AV35i = (short)(1) ;
         while ( AV35i <= AV36incluirNoRemuConCodigo.size() )
         {
            GXv_decimal2[0] = AV37incluNoRemuLiqDImpCalcu ;
            GXv_boolean4[0] = AV46existe ;
            GXv_int3[0] = AV38impuNoRemuLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV9EmpCod, AV18LiqNro, AV10LegNumero, (String)AV36incluirNoRemuConCodigo.elementAt(-1+AV35i), AV19ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal2, GXv_boolean4, GXv_int3) ;
            basecalculo_obligacion.this.AV37incluNoRemuLiqDImpCalcu = GXv_decimal2[0] ;
            basecalculo_obligacion.this.AV46existe = GXv_boolean4[0] ;
            basecalculo_obligacion.this.AV38impuNoRemuLiqDCalculado = GXv_int3[0] ;
            if ( ( AV38impuNoRemuLiqDCalculado == 0 ) && ( AV46existe ) )
            {
               AV24LiqDCalculado = (byte)(0) ;
               AV25error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( (String)AV36incluirNoRemuConCodigo.elementAt(-1+AV35i)) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               AV34Importes = AV34Importes.add(AV37incluNoRemuLiqDImpCalcu) ;
               AV32LiqDLog += httpContext.getMessage( " Suma ", "") + GXutil.trim( GXutil.str( AV37incluNoRemuLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( (String)AV36incluirNoRemuConCodigo.elementAt(-1+AV35i)) ;
            }
            AV35i = (short)(AV35i+1) ;
         }
      }
      if ( AV28OblDescu )
      {
         GXv_decimal2[0] = AV30descuLiqDImpCalcu ;
         GXv_int3[0] = AV31descuLiqDCalculado ;
         new web.getimpliqportipo(remoteHandle, context).execute( AV16CliCod, AV9EmpCod, AV18LiqNro, AV10LegNumero, AV11LiqPeriodo, "DES_ARG", AV12ConCodigo, AV19ProcesoLiquidacion, AV29excluiDescuConCodigo, GXv_decimal2, GXv_int3) ;
         basecalculo_obligacion.this.AV30descuLiqDImpCalcu = GXv_decimal2[0] ;
         basecalculo_obligacion.this.AV31descuLiqDCalculado = GXv_int3[0] ;
         if ( AV31descuLiqDCalculado == 0 )
         {
            AV24LiqDCalculado = (byte)(0) ;
            AV25error = httpContext.getMessage( "Falta calcular conceptos de descuento", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV34Importes = AV34Importes.subtract(AV30descuLiqDImpCalcu) ;
            AV32LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( AV30descuLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de conceptos de descuento", "") ;
            if ( AV29excluiDescuConCodigo.size() > 0 )
            {
               AV33excluidosStr = GXutil.strReplace( AV29excluiDescuConCodigo.toJSonString(false), "[", "") ;
               AV33excluidosStr = GXutil.strReplace( AV33excluidosStr, "]", "") ;
               if ( AV29excluiDescuConCodigo.size() > 1 )
               {
                  AV32LiqDLog += httpContext.getMessage( " (excepto los conceptos excluidos ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
               }
               else
               {
                  AV32LiqDLog += httpContext.getMessage( " (excepto el concepto excluido ", "") + GXutil.trim( AV33excluidosStr) + ")" ;
               }
            }
         }
      }
      else
      {
         AV35i = (short)(1) ;
         while ( AV35i <= AV39incluirDescuConCodigo.size() )
         {
            GXv_decimal2[0] = AV40incluDescuLiqDImpCalcu ;
            GXv_boolean4[0] = AV46existe ;
            GXv_int3[0] = AV41incluDescuLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV9EmpCod, AV18LiqNro, AV10LegNumero, (String)AV39incluirDescuConCodigo.elementAt(-1+AV35i), AV19ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal2, GXv_boolean4, GXv_int3) ;
            basecalculo_obligacion.this.AV40incluDescuLiqDImpCalcu = GXv_decimal2[0] ;
            basecalculo_obligacion.this.AV46existe = GXv_boolean4[0] ;
            basecalculo_obligacion.this.AV41incluDescuLiqDCalculado = GXv_int3[0] ;
            if ( ( AV41incluDescuLiqDCalculado == 0 ) && ( AV46existe ) )
            {
               AV24LiqDCalculado = (byte)(0) ;
               AV25error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( (String)AV39incluirDescuConCodigo.elementAt(-1+AV35i)) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               AV34Importes = AV34Importes.subtract(AV40incluDescuLiqDImpCalcu) ;
               AV32LiqDLog += httpContext.getMessage( " Resta ", "") + GXutil.trim( GXutil.str( AV40incluDescuLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( (String)AV39incluirDescuConCodigo.elementAt(-1+AV35i)) ;
            }
            AV35i = (short)(AV35i+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = basecalculo_obligacion.this.AV34Importes;
      this.aP11[0] = basecalculo_obligacion.this.AV25error;
      this.aP12[0] = basecalculo_obligacion.this.AV32LiqDLog;
      this.aP13[0] = basecalculo_obligacion.this.AV24LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV34Importes = DecimalUtil.ZERO ;
      AV25error = "" ;
      AV32LiqDLog = "" ;
      AV49Pgmname = "" ;
      scmdbuf = "" ;
      P019L2_A1172OblSecuencial = new short[1] ;
      P019L2_A6LegNumero = new int[1] ;
      P019L2_A1EmpCod = new short[1] ;
      P019L2_A3CliCod = new int[1] ;
      P019L2_A1181OblNoRemu = new boolean[] {false} ;
      P019L2_A1182OblDescu = new boolean[] {false} ;
      P019L3_A1172OblSecuencial = new short[1] ;
      P019L3_A6LegNumero = new int[1] ;
      P019L3_A1EmpCod = new short[1] ;
      P019L3_A3CliCod = new int[1] ;
      P019L3_A1170OblExcConCOdigo = new String[] {""} ;
      P019L3_A1183OblExcTipo = new String[] {""} ;
      A1170OblExcConCOdigo = "" ;
      A1183OblExcTipo = "" ;
      AV17TipoConCod = "" ;
      GXv_char1 = new String[1] ;
      AV14excluirRemunConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21excluirNoRemunConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29excluiDescuConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36incluirNoRemuConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39incluirDescuConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22remunerativosLiqDImpCalcu = DecimalUtil.ZERO ;
      AV33excluidosStr = "" ;
      AV26noRemuLiqDImpCalcu = DecimalUtil.ZERO ;
      AV37incluNoRemuLiqDImpCalcu = DecimalUtil.ZERO ;
      AV30descuLiqDImpCalcu = DecimalUtil.ZERO ;
      AV40incluDescuLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_int3 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.basecalculo_obligacion__default(),
         new Object[] {
             new Object[] {
            P019L2_A1172OblSecuencial, P019L2_A6LegNumero, P019L2_A1EmpCod, P019L2_A3CliCod, P019L2_A1181OblNoRemu, P019L2_A1182OblDescu
            }
            , new Object[] {
            P019L3_A1172OblSecuencial, P019L3_A6LegNumero, P019L3_A1EmpCod, P019L3_A3CliCod, P019L3_A1170OblExcConCOdigo, P019L3_A1183OblExcTipo
            }
         }
      );
      AV49Pgmname = "baseCalculo_obligacion" ;
      /* GeneXus formulas. */
      AV49Pgmname = "baseCalculo_obligacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24LiqDCalculado ;
   private byte AV23remuLiqDCalculado ;
   private byte AV27noRemuLiqDCalculado ;
   private byte AV38impuNoRemuLiqDCalculado ;
   private byte AV31descuLiqDCalculado ;
   private byte AV41incluDescuLiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV9EmpCod ;
   private short AV44OblSecuencial ;
   private short AV42PaiCod ;
   private short A1172OblSecuencial ;
   private short A1EmpCod ;
   private short AV35i ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV18LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV34Importes ;
   private java.math.BigDecimal AV22remunerativosLiqDImpCalcu ;
   private java.math.BigDecimal AV26noRemuLiqDImpCalcu ;
   private java.math.BigDecimal AV37incluNoRemuLiqDImpCalcu ;
   private java.math.BigDecimal AV30descuLiqDImpCalcu ;
   private java.math.BigDecimal AV40incluDescuLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV12ConCodigo ;
   private String AV19ProcesoLiquidacion ;
   private String AV49Pgmname ;
   private String scmdbuf ;
   private String A1170OblExcConCOdigo ;
   private String A1183OblExcTipo ;
   private String AV17TipoConCod ;
   private String GXv_char1[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV13insertandoConceptos ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean AV20OblNoRemu ;
   private boolean AV28OblDescu ;
   private boolean returnInSub ;
   private boolean AV46existe ;
   private boolean GXv_boolean4[] ;
   private String AV32LiqDLog ;
   private String AV25error ;
   private String AV33excluidosStr ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private short[] P019L2_A1172OblSecuencial ;
   private int[] P019L2_A6LegNumero ;
   private short[] P019L2_A1EmpCod ;
   private int[] P019L2_A3CliCod ;
   private boolean[] P019L2_A1181OblNoRemu ;
   private boolean[] P019L2_A1182OblDescu ;
   private short[] P019L3_A1172OblSecuencial ;
   private int[] P019L3_A6LegNumero ;
   private short[] P019L3_A1EmpCod ;
   private int[] P019L3_A3CliCod ;
   private String[] P019L3_A1170OblExcConCOdigo ;
   private String[] P019L3_A1183OblExcTipo ;
   private GXSimpleCollection<String> AV14excluirRemunConCodigo ;
   private GXSimpleCollection<String> AV21excluirNoRemunConCodigo ;
   private GXSimpleCollection<String> AV29excluiDescuConCodigo ;
   private GXSimpleCollection<String> AV36incluirNoRemuConCodigo ;
   private GXSimpleCollection<String> AV39incluirDescuConCodigo ;
}

final  class basecalculo_obligacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019L2", "SELECT OblSecuencial, LegNumero, EmpCod, CliCod, OblNoRemu, OblDescu FROM Obligacion WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019L3", "SELECT OblSecuencial, LegNumero, EmpCod, CliCod, OblExcConCOdigo, OblExcTipo FROM ObligacionExcepciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

