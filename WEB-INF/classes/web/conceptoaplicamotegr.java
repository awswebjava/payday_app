package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoaplicamotegr extends GXProcedure
{
   public conceptoaplicamotegr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoaplicamotegr.class ), "" );
   }

   public conceptoaplicamotegr( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           String aP3 ,
                                           boolean[] aP4 )
   {
      conceptoaplicamotegr.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        boolean[] aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             boolean[] aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      conceptoaplicamotegr.this.AV9CliCod = aP0;
      conceptoaplicamotegr.this.AV11EmpCod = aP1;
      conceptoaplicamotegr.this.AV12LegNumero = aP2;
      conceptoaplicamotegr.this.AV10ConCodigo = aP3;
      conceptoaplicamotegr.this.aP4 = aP4;
      conceptoaplicamotegr.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV18LegFecIngreso ;
      GXv_char2[0] = AV13MegCodigo ;
      GXv_date3[0] = AV16LegFecEgreso ;
      GXv_date4[0] = AV14LegFecPreAviso ;
      new web.legingresoegresoypreaviso(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV12LegNumero, GXv_date1, GXv_char2, GXv_date3, GXv_date4) ;
      conceptoaplicamotegr.this.AV18LegFecIngreso = GXv_date1[0] ;
      conceptoaplicamotegr.this.AV13MegCodigo = GXv_char2[0] ;
      conceptoaplicamotegr.this.AV16LegFecEgreso = GXv_date3[0] ;
      conceptoaplicamotegr.this.AV14LegFecPreAviso = GXv_date4[0] ;
      AV36GXLvl3 = (byte)(0) ;
      /* Using cursor P01F92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01F92_A26ConCodigo[0] ;
         A3CliCod = P01F92_A3CliCod[0] ;
         A1532MegPreaTipo = P01F92_A1532MegPreaTipo[0] ;
         A11MegCodigo = P01F92_A11MegCodigo[0] ;
         A2077ConMegSec = P01F92_A2077ConMegSec[0] ;
         AV36GXLvl3 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl3 == 0 )
      {
         AV8aplica = true ;
         AV26ConMegPropor = DecimalUtil.doubleToDec(1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "cli ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " concodigo ", "")+GXutil.trim( AV10ConCodigo)+httpContext.getMessage( " aplica ", "")+GXutil.trim( GXutil.booltostr( AV8aplica))) ;
      if ( ! AV8aplica )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&MegCodigo ", "")+GXutil.trim( AV13MegCodigo)) ;
         AV21palabra = "[antiguedad_indemnizacion]" ;
         GXv_int5[0] = AV24antiguedadAnios ;
         GXv_char2[0] = "" ;
         new web.antiguedad_anios(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV12LegNumero, AV16LegFecEgreso, AV21palabra, GXv_int5, GXv_char2) ;
         conceptoaplicamotegr.this.AV24antiguedadAnios = GXv_int5[0] ;
         GXv_int5[0] = AV19antiguedadMeses ;
         new web.diferenciameses(remoteHandle, context).execute( AV9CliCod, AV18LegFecIngreso, AV16LegFecEgreso, (short)(12), GXv_int5) ;
         conceptoaplicamotegr.this.AV19antiguedadMeses = GXv_int5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 1", "")) ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14LegFecPreAviso)) )
         {
            AV20huboPreAviso = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 2", "")) ;
         }
         else
         {
            AV20huboPreAviso = true ;
            GXv_int5[0] = AV27PaiCod ;
            new web.empresagetpais(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, GXv_int5) ;
            conceptoaplicamotegr.this.AV27PaiCod = GXv_int5[0] ;
            AV32encontro = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 3", "")) ;
            /* Using cursor P01F93 */
            pr_default.execute(1, new Object[] {Short.valueOf(AV27PaiCod)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A46PaiCod = P01F93_A46PaiCod[0] ;
               A1536PaiAntMayDur = P01F93_A1536PaiAntMayDur[0] ;
               A1537PaiPreAviCant = P01F93_A1537PaiPreAviCant[0] ;
               A1538PaiPreAviDur = P01F93_A1538PaiPreAviDur[0] ;
               A1535PaiAntMayCant = P01F93_A1535PaiAntMayCant[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 4 &antiguedadAnios ", "")+GXutil.trim( GXutil.str( AV24antiguedadAnios, 4, 0))+httpContext.getMessage( " PaiAntMayCant ", "")+GXutil.trim( GXutil.str( A1535PaiAntMayCant, 2, 0))) ;
               if ( AV24antiguedadAnios > A1535PaiAntMayCant )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 5", "")) ;
                  AV29anticipacion = A1537PaiPreAviCant ;
                  AV31anticipacionTipo = A1538PaiPreAviDur ;
                  AV32encontro = true ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            if ( ! AV32encontro )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 6", "")) ;
               /* Using cursor P01F94 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV27PaiCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A46PaiCod = P01F94_A46PaiCod[0] ;
                  A1536PaiAntMayDur = P01F94_A1536PaiAntMayDur[0] ;
                  A1537PaiPreAviCant = P01F94_A1537PaiPreAviCant[0] ;
                  A1538PaiPreAviDur = P01F94_A1538PaiPreAviDur[0] ;
                  A1535PaiAntMayCant = P01F94_A1535PaiAntMayCant[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 7 ", "")) ;
                  if ( AV19antiguedadMeses > A1535PaiAntMayCant )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "hubo 8", "")) ;
                     AV29anticipacion = A1537PaiPreAviCant ;
                     AV31anticipacionTipo = A1538PaiPreAviDur ;
                     AV32encontro = true ;
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
                  pr_default.readNext(2);
               }
               pr_default.close(2);
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&anticipacionTipo ", "")+GXutil.trim( AV31anticipacionTipo)) ;
            if ( GXutil.strcmp(AV31anticipacionTipo, "meses") == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "es meses", "")) ;
               GXv_int5[0] = AV33anticipacionPreaviso ;
               new web.diferenciameses(remoteHandle, context).execute( AV9CliCod, AV14LegFecPreAviso, AV16LegFecEgreso, AV29anticipacion, GXv_int5) ;
               conceptoaplicamotegr.this.AV33anticipacionPreaviso = GXv_int5[0] ;
            }
            else
            {
               AV33anticipacionPreaviso = (short)(GXutil.ddiff(AV16LegFecEgreso,AV14LegFecPreAviso)) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "es dias &LegFecEgreso ", "")+GXutil.trim( localUtil.dtoc( AV16LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegFecPreAviso ", "")+GXutil.trim( localUtil.dtoc( AV14LegFecPreAviso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&anticipacionPreaviso ", "")+GXutil.trim( GXutil.str( AV33anticipacionPreaviso, 4, 0))+httpContext.getMessage( " &anticipacion ", "")+GXutil.trim( GXutil.str( AV29anticipacion, 4, 0))) ;
            if ( AV33anticipacionPreaviso < AV29anticipacion )
            {
               AV20huboPreAviso = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "poca anticipacion", "")) ;
            }
         }
         /* Using cursor P01F95 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV9CliCod), AV10ConCodigo, AV13MegCodigo});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A3CliCod = P01F95_A3CliCod[0] ;
            A26ConCodigo = P01F95_A26ConCodigo[0] ;
            A11MegCodigo = P01F95_A11MegCodigo[0] ;
            A1534ConMegDura = P01F95_A1534ConMegDura[0] ;
            A1532MegPreaTipo = P01F95_A1532MegPreaTipo[0] ;
            A1529ConMegPropor = P01F95_A1529ConMegPropor[0] ;
            A1530ConMegMeses = P01F95_A1530ConMegMeses[0] ;
            A2077ConMegSec = P01F95_A2077ConMegSec[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "MegPreaTipo ", "")+GXutil.trim( A1532MegPreaTipo)+httpContext.getMessage( " &&huboPreAviso ", "")+GXutil.trim( GXutil.booltostr( AV20huboPreAviso))) ;
            if ( (GXutil.strcmp("", A1532MegPreaTipo)==0) || ( ( GXutil.strcmp(A1532MegPreaTipo, "CON") == 0 ) && ( AV20huboPreAviso ) ) || ( ( GXutil.strcmp(A1532MegPreaTipo, "SIN") == 0 ) && ! AV20huboPreAviso ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "años ", "")+GXutil.trim( GXutil.str( AV24antiguedadAnios, 4, 0))+httpContext.getMessage( " ConMegMeses ", "")+GXutil.trim( GXutil.str( A1530ConMegMeses, 2, 0))) ;
               if ( AV24antiguedadAnios > A1530ConMegMeses )
               {
                  AV8aplica = true ;
                  AV26ConMegPropor = A1529ConMegPropor ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "aplicalororo1", "")) ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( ! AV8aplica )
         {
            /* Using cursor P01F96 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV9CliCod), AV10ConCodigo, AV13MegCodigo});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A3CliCod = P01F96_A3CliCod[0] ;
               A26ConCodigo = P01F96_A26ConCodigo[0] ;
               A11MegCodigo = P01F96_A11MegCodigo[0] ;
               A1534ConMegDura = P01F96_A1534ConMegDura[0] ;
               A1532MegPreaTipo = P01F96_A1532MegPreaTipo[0] ;
               A1529ConMegPropor = P01F96_A1529ConMegPropor[0] ;
               A1530ConMegMeses = P01F96_A1530ConMegMeses[0] ;
               A2077ConMegSec = P01F96_A2077ConMegSec[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "MegPreaTipo ", "")+GXutil.trim( A1532MegPreaTipo)+httpContext.getMessage( " &&huboPreAviso ", "")+GXutil.trim( GXutil.booltostr( AV20huboPreAviso))) ;
               if ( (GXutil.strcmp("", A1532MegPreaTipo)==0) || ( ( GXutil.strcmp(A1532MegPreaTipo, "CON") == 0 ) && ( AV20huboPreAviso ) ) || ( ( GXutil.strcmp(A1532MegPreaTipo, "SIN") == 0 ) && ! AV20huboPreAviso ) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "meses ", "")+GXutil.trim( GXutil.str( AV19antiguedadMeses, 4, 0))+httpContext.getMessage( " ConMegMeses ", "")+GXutil.trim( GXutil.str( A1530ConMegMeses, 2, 0))) ;
                  if ( AV19antiguedadMeses > A1530ConMegMeses )
                  {
                     AV8aplica = true ;
                     AV26ConMegPropor = A1529ConMegPropor ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "aplicalororo2 &ConMegPropor ", "")+GXutil.trim( GXutil.str( AV26ConMegPropor, 6, 4))) ;
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
               }
               pr_default.readNext(4);
            }
            pr_default.close(4);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = conceptoaplicamotegr.this.AV8aplica;
      this.aP5[0] = conceptoaplicamotegr.this.AV26ConMegPropor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26ConMegPropor = DecimalUtil.ZERO ;
      AV18LegFecIngreso = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV13MegCodigo = "" ;
      AV16LegFecEgreso = GXutil.nullDate() ;
      GXv_date3 = new java.util.Date[1] ;
      AV14LegFecPreAviso = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      scmdbuf = "" ;
      P01F92_A26ConCodigo = new String[] {""} ;
      P01F92_A3CliCod = new int[1] ;
      P01F92_A1532MegPreaTipo = new String[] {""} ;
      P01F92_A11MegCodigo = new String[] {""} ;
      P01F92_A2077ConMegSec = new short[1] ;
      A26ConCodigo = "" ;
      A1532MegPreaTipo = "" ;
      A11MegCodigo = "" ;
      AV37Pgmname = "" ;
      AV21palabra = "" ;
      GXv_char2 = new String[1] ;
      P01F93_A46PaiCod = new short[1] ;
      P01F93_A1536PaiAntMayDur = new String[] {""} ;
      P01F93_A1537PaiPreAviCant = new byte[1] ;
      P01F93_A1538PaiPreAviDur = new String[] {""} ;
      P01F93_A1535PaiAntMayCant = new byte[1] ;
      A1536PaiAntMayDur = "" ;
      A1538PaiPreAviDur = "" ;
      AV31anticipacionTipo = "" ;
      P01F94_A46PaiCod = new short[1] ;
      P01F94_A1536PaiAntMayDur = new String[] {""} ;
      P01F94_A1537PaiPreAviCant = new byte[1] ;
      P01F94_A1538PaiPreAviDur = new String[] {""} ;
      P01F94_A1535PaiAntMayCant = new byte[1] ;
      GXv_int5 = new short[1] ;
      P01F95_A3CliCod = new int[1] ;
      P01F95_A26ConCodigo = new String[] {""} ;
      P01F95_A11MegCodigo = new String[] {""} ;
      P01F95_A1534ConMegDura = new String[] {""} ;
      P01F95_A1532MegPreaTipo = new String[] {""} ;
      P01F95_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01F95_A1530ConMegMeses = new byte[1] ;
      P01F95_A2077ConMegSec = new short[1] ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      P01F96_A3CliCod = new int[1] ;
      P01F96_A26ConCodigo = new String[] {""} ;
      P01F96_A11MegCodigo = new String[] {""} ;
      P01F96_A1534ConMegDura = new String[] {""} ;
      P01F96_A1532MegPreaTipo = new String[] {""} ;
      P01F96_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01F96_A1530ConMegMeses = new byte[1] ;
      P01F96_A2077ConMegSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoaplicamotegr__default(),
         new Object[] {
             new Object[] {
            P01F92_A26ConCodigo, P01F92_A3CliCod, P01F92_A1532MegPreaTipo, P01F92_A11MegCodigo, P01F92_A2077ConMegSec
            }
            , new Object[] {
            P01F93_A46PaiCod, P01F93_A1536PaiAntMayDur, P01F93_A1537PaiPreAviCant, P01F93_A1538PaiPreAviDur, P01F93_A1535PaiAntMayCant
            }
            , new Object[] {
            P01F94_A46PaiCod, P01F94_A1536PaiAntMayDur, P01F94_A1537PaiPreAviCant, P01F94_A1538PaiPreAviDur, P01F94_A1535PaiAntMayCant
            }
            , new Object[] {
            P01F95_A3CliCod, P01F95_A26ConCodigo, P01F95_A11MegCodigo, P01F95_A1534ConMegDura, P01F95_A1532MegPreaTipo, P01F95_A1529ConMegPropor, P01F95_A1530ConMegMeses, P01F95_A2077ConMegSec
            }
            , new Object[] {
            P01F96_A3CliCod, P01F96_A26ConCodigo, P01F96_A11MegCodigo, P01F96_A1534ConMegDura, P01F96_A1532MegPreaTipo, P01F96_A1529ConMegPropor, P01F96_A1530ConMegMeses, P01F96_A2077ConMegSec
            }
         }
      );
      AV37Pgmname = "conceptoAplicaMotEgr" ;
      /* GeneXus formulas. */
      AV37Pgmname = "conceptoAplicaMotEgr" ;
      Gx_err = (short)(0) ;
   }

   private byte AV36GXLvl3 ;
   private byte A1537PaiPreAviCant ;
   private byte A1535PaiAntMayCant ;
   private byte A1530ConMegMeses ;
   private short AV11EmpCod ;
   private short A2077ConMegSec ;
   private short AV24antiguedadAnios ;
   private short AV19antiguedadMeses ;
   private short AV27PaiCod ;
   private short A46PaiCod ;
   private short AV29anticipacion ;
   private short AV33anticipacionPreaviso ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV12LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV26ConMegPropor ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String AV10ConCodigo ;
   private String AV13MegCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1532MegPreaTipo ;
   private String A11MegCodigo ;
   private String AV37Pgmname ;
   private String AV21palabra ;
   private String GXv_char2[] ;
   private String A1536PaiAntMayDur ;
   private String A1538PaiPreAviDur ;
   private String AV31anticipacionTipo ;
   private String A1534ConMegDura ;
   private java.util.Date AV18LegFecIngreso ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV16LegFecEgreso ;
   private java.util.Date GXv_date3[] ;
   private java.util.Date AV14LegFecPreAviso ;
   private java.util.Date GXv_date4[] ;
   private boolean AV8aplica ;
   private boolean AV20huboPreAviso ;
   private boolean AV32encontro ;
   private java.math.BigDecimal[] aP5 ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01F92_A26ConCodigo ;
   private int[] P01F92_A3CliCod ;
   private String[] P01F92_A1532MegPreaTipo ;
   private String[] P01F92_A11MegCodigo ;
   private short[] P01F92_A2077ConMegSec ;
   private short[] P01F93_A46PaiCod ;
   private String[] P01F93_A1536PaiAntMayDur ;
   private byte[] P01F93_A1537PaiPreAviCant ;
   private String[] P01F93_A1538PaiPreAviDur ;
   private byte[] P01F93_A1535PaiAntMayCant ;
   private short[] P01F94_A46PaiCod ;
   private String[] P01F94_A1536PaiAntMayDur ;
   private byte[] P01F94_A1537PaiPreAviCant ;
   private String[] P01F94_A1538PaiPreAviDur ;
   private byte[] P01F94_A1535PaiAntMayCant ;
   private int[] P01F95_A3CliCod ;
   private String[] P01F95_A26ConCodigo ;
   private String[] P01F95_A11MegCodigo ;
   private String[] P01F95_A1534ConMegDura ;
   private String[] P01F95_A1532MegPreaTipo ;
   private java.math.BigDecimal[] P01F95_A1529ConMegPropor ;
   private byte[] P01F95_A1530ConMegMeses ;
   private short[] P01F95_A2077ConMegSec ;
   private int[] P01F96_A3CliCod ;
   private String[] P01F96_A26ConCodigo ;
   private String[] P01F96_A11MegCodigo ;
   private String[] P01F96_A1534ConMegDura ;
   private String[] P01F96_A1532MegPreaTipo ;
   private java.math.BigDecimal[] P01F96_A1529ConMegPropor ;
   private byte[] P01F96_A1530ConMegMeses ;
   private short[] P01F96_A2077ConMegSec ;
}

final  class conceptoaplicamotegr__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01F92", "SELECT ConCodigo, CliCod, MegPreaTipo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01F93", "SELECT PaiCod, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur, PaiAntMayCant FROM Paispreaviso WHERE PaiCod = ? and PaiAntMayDur = ( 'años') ORDER BY PaiCod, PaiAntMayDur, PaiAntMayCant DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01F94", "SELECT PaiCod, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur, PaiAntMayCant FROM Paispreaviso WHERE PaiCod = ? and PaiAntMayDur = ( 'meses') ORDER BY PaiCod, PaiAntMayDur, PaiAntMayCant DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01F95", "SELECT CliCod, ConCodigo, MegCodigo, ConMegDura, MegPreaTipo, ConMegPropor, ConMegMeses, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegDura = ( 'años') ORDER BY CliCod, ConCodigo, MegCodigo, ConMegDura, ConMegMeses DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01F96", "SELECT CliCod, ConCodigo, MegCodigo, ConMegDura, MegPreaTipo, ConMegPropor, ConMegMeses, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegDura = ( 'meses') ORDER BY CliCod, ConCodigo, MegCodigo, ConMegDura, ConMegMeses DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

