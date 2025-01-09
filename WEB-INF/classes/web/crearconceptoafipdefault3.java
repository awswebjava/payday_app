package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearconceptoafipdefault3 extends GXProcedure
{
   public crearconceptoafipdefault3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearconceptoafipdefault3.class ), "" );
   }

   public crearconceptoafipdefault3( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      crearconceptoafipdefault3.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 )
   {
      crearconceptoafipdefault3.this.AV8CliCod = aP0;
      crearconceptoafipdefault3.this.AV9ConCodPropio = aP1;
      crearconceptoafipdefault3.this.aP2 = aP2;
      crearconceptoafipdefault3.this.aP3 = aP3;
      crearconceptoafipdefault3.this.aP4 = aP4;
      crearconceptoafipdefault3.this.aP5 = aP5;
      crearconceptoafipdefault3.this.aP6 = aP6;
      crearconceptoafipdefault3.this.aP7 = aP7;
      crearconceptoafipdefault3.this.aP8 = aP8;
      crearconceptoafipdefault3.this.aP9 = aP9;
      crearconceptoafipdefault3.this.aP10 = aP10;
      crearconceptoafipdefault3.this.aP11 = aP11;
      crearconceptoafipdefault3.this.aP12 = aP12;
      crearconceptoafipdefault3.this.aP13 = aP13;
      crearconceptoafipdefault3.this.aP14 = aP14;
      crearconceptoafipdefault3.this.aP15 = aP15;
      crearconceptoafipdefault3.this.aP16 = aP16;
      crearconceptoafipdefault3.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV30sacConCodigo ;
      GXt_char2 = AV30sacConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      crearconceptoafipdefault3.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      crearconceptoafipdefault3.this.GXt_char1 = GXv_char4[0] ;
      AV30sacConCodigo = GXt_char1 ;
      GXv_char4[0] = AV12SubTipoConCod1 ;
      GXv_char3[0] = AV11SubTipoConCod2 ;
      new web.conceptogetsubtipos(remoteHandle, context).execute( AV8CliCod, AV9ConCodPropio, GXv_char4, GXv_char3) ;
      crearconceptoafipdefault3.this.AV12SubTipoConCod1 = GXv_char4[0] ;
      crearconceptoafipdefault3.this.AV11SubTipoConCod2 = GXv_char3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&CONCODPROPIO ", "")+GXutil.trim( AV9ConCodPropio)) ;
      if ( ! (GXutil.strcmp("", AV11SubTipoConCod2)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV10AFIPConCod = AV11SubTipoConCod2 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "1") ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "2") ;
         if ( ! (GXutil.strcmp("", AV12SubTipoConCod1)==0) && ( GXutil.strcmp(AV12SubTipoConCod1, new web.subtipoanticipodesueldo(remoteHandle, context).executeUdp( )) != 0 ) && ( GXutil.strcmp(AV12SubTipoConCod1, new web.subtipoanticipocuotas(remoteHandle, context).executeUdp( )) != 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV10AFIPConCod = AV12SubTipoConCod1 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "3") ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "3b", "")) ;
            if ( ( GXutil.strcmp(AV12SubTipoConCod1, new web.subtipoanticipodesueldo(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV12SubTipoConCod1, new web.subtipoanticipocuotas(remoteHandle, context).executeUdp( )) == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "3c", "")) ;
               GXt_char2 = AV10AFIPConCod ;
               GXv_char4[0] = GXt_char2 ;
               new web.subtipodescuentootros(remoteHandle, context).execute( GXv_char4) ;
               crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
               AV10AFIPConCod = GXt_char2 ;
            }
         }
      }
      if ( ! (GXutil.strcmp("", AV10AFIPConCod)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "4") ;
         AV39GXLvl29 = (byte)(0) ;
         /* Using cursor P01JD2 */
         pr_default.execute(0, new Object[] {AV10AFIPConCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A72AFIPConCod = P01JD2_A72AFIPConCod[0] ;
            AV39GXLvl29 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "5") ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV39GXLvl29 == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV10AFIPConCod = "" ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "6") ;
         }
      }
      if ( ( GXutil.strcmp(AV9ConCodPropio, AV30sacConCodigo) == 0 ) && ! (GXutil.strcmp("", AV10AFIPConCod)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV31veces = (short)(3) ;
      }
      else
      {
         AV31veces = (short)(1) ;
      }
      AV29i = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "6 VECES ", "")+GXutil.trim( GXutil.str( AV31veces, 4, 0))) ;
      while ( AV29i <= AV31veces )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "7") ;
         GXv_char4[0] = AV32ConDescrip ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV9ConCodPropio, GXv_char4) ;
         crearconceptoafipdefault3.this.AV32ConDescrip = GXv_char4[0] ;
         GXt_char2 = AV33descuentoAdelantoVacConDescrip ;
         GXv_char4[0] = GXt_char2 ;
         new web.descripdescuentoadelantovacaciones(remoteHandle, context).execute( GXv_char4) ;
         crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
         AV33descuentoAdelantoVacConDescrip = GXt_char2 ;
         if ( ! (GXutil.strcmp("", AV10AFIPConCod)==0) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "VACACIONES", "")) != 0 ) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), GXutil.trim( AV33descuentoAdelantoVacConDescrip)) != 0 ) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "ADELANTO DE VACACIONES", "")) != 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "8") ;
            if ( ( AV31veces == 1 ) || ( AV29i == 1 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV35ConAFIPConcepto = AV10AFIPConCod ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "9") ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "10") ;
               if ( AV31veces == 3 )
               {
                  if ( AV29i == 2 )
                  {
                     AV35ConAFIPConcepto = "120001" ;
                  }
                  else
                  {
                     AV35ConAFIPConcepto = "120002" ;
                  }
               }
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "11 "+AV32ConDescrip) ;
            if ( ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "ADELANTO DE VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "")) == 0 ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "12a", "")) ;
               GXt_char2 = AV35ConAFIPConcepto ;
               GXv_char4[0] = GXt_char2 ;
               new web.subtipo2vacacioneslibre(remoteHandle, context).execute( GXv_char4) ;
               crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
               AV35ConAFIPConcepto = GXt_char2 ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "12b", "")) ;
            }
            else
            {
               GXt_char2 = AV34descuVacDescrip ;
               GXv_char4[0] = GXt_char2 ;
               new web.descripdescuentoadelantovacaciones(remoteHandle, context).execute( GXv_char4) ;
               crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
               AV34descuVacDescrip = GXt_char2 ;
               if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), GXutil.upper( GXutil.trim( AV34descuVacDescrip))) == 0 )
               {
                  GXt_char2 = AV35ConAFIPConcepto ;
                  GXv_char4[0] = GXt_char2 ;
                  new web.subtipo2vacacioneslibre(remoteHandle, context).execute( GXv_char4) ;
                  crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
                  AV35ConAFIPConcepto = GXt_char2 ;
               }
               else
               {
                  if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV32ConDescrip)), httpContext.getMessage( "SOBREGIRO", "")) == 0 )
                  {
                     GXt_char2 = AV35ConAFIPConcepto ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.subtiporedondeo(remoteHandle, context).execute( GXv_char4) ;
                     crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
                     AV35ConAFIPConcepto = GXt_char2 ;
                  }
                  else
                  {
                     AV35ConAFIPConcepto = "" ;
                  }
               }
            }
         }
         A134ConAFIPMarcaRep = "0" ;
         AV14ConAFIPSIPAApo = "" ;
         AV22ConAFIPSIPACont = "" ;
         AV23ConAFIPINSSJyPApo = "" ;
         AV15ConAFIPINSSJyPCont = "" ;
         AV24ConAFIPObraSocApo = "" ;
         AV27ConAFIPObraSocCont = "" ;
         AV16ConAFIPFonSolRedApo = "" ;
         AV17ConAFIPFonSolRedCont = "" ;
         AV28ConAFIPRenateaApo = "" ;
         AV21ConAFIPRenateaCont = "" ;
         AV18ConAFIPAsigFamCont = "" ;
         AV25ConAFIPFonNacEmpCont = "" ;
         AV26ConAFIPLeyRieTrabCont = "" ;
         AV20ConAFIPRegDifApo = "" ;
         AV19ConAFIPRegEspApo = "" ;
         GXt_char2 = AV13ConAFIPTipo ;
         GXv_char4[0] = GXt_char2 ;
         new web.conceptogettipo(remoteHandle, context).execute( AV8CliCod, AV9ConCodPropio, GXv_char4) ;
         crearconceptoafipdefault3.this.GXt_char2 = GXv_char4[0] ;
         AV13ConAFIPTipo = GXt_char2 ;
         if ( ( GXutil.strcmp(AV13ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(AV13ConAFIPTipo, "NRE_ARG") == 0 ) )
         {
            AV14ConAFIPSIPAApo = "0" ;
            AV22ConAFIPSIPACont = "0" ;
            AV23ConAFIPINSSJyPApo = "0" ;
            AV15ConAFIPINSSJyPCont = "0" ;
            AV24ConAFIPObraSocApo = "0" ;
            AV27ConAFIPObraSocCont = "0" ;
            AV16ConAFIPFonSolRedApo = "0" ;
            AV17ConAFIPFonSolRedCont = "0" ;
            AV28ConAFIPRenateaApo = "0" ;
            AV21ConAFIPRenateaCont = "0" ;
            AV18ConAFIPAsigFamCont = "0" ;
            AV25ConAFIPFonNacEmpCont = "0" ;
            AV26ConAFIPLeyRieTrabCont = "0" ;
            AV20ConAFIPRegDifApo = "0" ;
            AV19ConAFIPRegEspApo = "0" ;
         }
         else
         {
            AV14ConAFIPSIPAApo = "1" ;
            AV22ConAFIPSIPACont = "1" ;
            AV23ConAFIPINSSJyPApo = "1" ;
            AV15ConAFIPINSSJyPCont = "1" ;
            AV24ConAFIPObraSocApo = "1" ;
            AV27ConAFIPObraSocCont = "1" ;
            AV16ConAFIPFonSolRedApo = "1" ;
            AV17ConAFIPFonSolRedCont = "1" ;
            AV28ConAFIPRenateaApo = "1" ;
            AV21ConAFIPRenateaCont = "1" ;
            AV18ConAFIPAsigFamCont = "1" ;
            AV25ConAFIPFonNacEmpCont = "1" ;
            AV26ConAFIPLeyRieTrabCont = "1" ;
            AV20ConAFIPRegDifApo = "0" ;
            AV19ConAFIPRegEspApo = "0" ;
         }
         AV29i = (short)(AV29i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = crearconceptoafipdefault3.this.AV14ConAFIPSIPAApo;
      this.aP3[0] = crearconceptoafipdefault3.this.AV15ConAFIPINSSJyPCont;
      this.aP4[0] = crearconceptoafipdefault3.this.AV16ConAFIPFonSolRedApo;
      this.aP5[0] = crearconceptoafipdefault3.this.AV17ConAFIPFonSolRedCont;
      this.aP6[0] = crearconceptoafipdefault3.this.AV18ConAFIPAsigFamCont;
      this.aP7[0] = crearconceptoafipdefault3.this.AV19ConAFIPRegEspApo;
      this.aP8[0] = crearconceptoafipdefault3.this.AV20ConAFIPRegDifApo;
      this.aP9[0] = crearconceptoafipdefault3.this.AV21ConAFIPRenateaCont;
      this.aP10[0] = crearconceptoafipdefault3.this.AV22ConAFIPSIPACont;
      this.aP11[0] = crearconceptoafipdefault3.this.AV23ConAFIPINSSJyPApo;
      this.aP12[0] = crearconceptoafipdefault3.this.AV24ConAFIPObraSocApo;
      this.aP13[0] = crearconceptoafipdefault3.this.AV25ConAFIPFonNacEmpCont;
      this.aP14[0] = crearconceptoafipdefault3.this.AV26ConAFIPLeyRieTrabCont;
      this.aP15[0] = crearconceptoafipdefault3.this.AV27ConAFIPObraSocCont;
      this.aP16[0] = crearconceptoafipdefault3.this.AV28ConAFIPRenateaApo;
      this.aP17[0] = crearconceptoafipdefault3.this.AV35ConAFIPConcepto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14ConAFIPSIPAApo = "" ;
      AV15ConAFIPINSSJyPCont = "" ;
      AV16ConAFIPFonSolRedApo = "" ;
      AV17ConAFIPFonSolRedCont = "" ;
      AV18ConAFIPAsigFamCont = "" ;
      AV19ConAFIPRegEspApo = "" ;
      AV20ConAFIPRegDifApo = "" ;
      AV21ConAFIPRenateaCont = "" ;
      AV22ConAFIPSIPACont = "" ;
      AV23ConAFIPINSSJyPApo = "" ;
      AV24ConAFIPObraSocApo = "" ;
      AV25ConAFIPFonNacEmpCont = "" ;
      AV26ConAFIPLeyRieTrabCont = "" ;
      AV27ConAFIPObraSocCont = "" ;
      AV28ConAFIPRenateaApo = "" ;
      AV35ConAFIPConcepto = "" ;
      AV30sacConCodigo = "" ;
      GXt_char1 = "" ;
      AV12SubTipoConCod1 = "" ;
      AV11SubTipoConCod2 = "" ;
      GXv_char3 = new String[1] ;
      AV38Pgmname = "" ;
      AV10AFIPConCod = "" ;
      scmdbuf = "" ;
      P01JD2_A72AFIPConCod = new String[] {""} ;
      A72AFIPConCod = "" ;
      AV32ConDescrip = "" ;
      AV33descuentoAdelantoVacConDescrip = "" ;
      AV34descuVacDescrip = "" ;
      A134ConAFIPMarcaRep = "" ;
      AV13ConAFIPTipo = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.crearconceptoafipdefault3__default(),
         new Object[] {
             new Object[] {
            P01JD2_A72AFIPConCod
            }
         }
      );
      AV38Pgmname = "crearConceptoAFIPDefault3" ;
      /* GeneXus formulas. */
      AV38Pgmname = "crearConceptoAFIPDefault3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV39GXLvl29 ;
   private short AV31veces ;
   private short AV29i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9ConCodPropio ;
   private String AV14ConAFIPSIPAApo ;
   private String AV15ConAFIPINSSJyPCont ;
   private String AV16ConAFIPFonSolRedApo ;
   private String AV17ConAFIPFonSolRedCont ;
   private String AV18ConAFIPAsigFamCont ;
   private String AV19ConAFIPRegEspApo ;
   private String AV20ConAFIPRegDifApo ;
   private String AV21ConAFIPRenateaCont ;
   private String AV22ConAFIPSIPACont ;
   private String AV23ConAFIPINSSJyPApo ;
   private String AV24ConAFIPObraSocApo ;
   private String AV25ConAFIPFonNacEmpCont ;
   private String AV26ConAFIPLeyRieTrabCont ;
   private String AV27ConAFIPObraSocCont ;
   private String AV28ConAFIPRenateaApo ;
   private String AV35ConAFIPConcepto ;
   private String AV30sacConCodigo ;
   private String GXt_char1 ;
   private String AV12SubTipoConCod1 ;
   private String AV11SubTipoConCod2 ;
   private String GXv_char3[] ;
   private String AV38Pgmname ;
   private String AV10AFIPConCod ;
   private String scmdbuf ;
   private String A72AFIPConCod ;
   private String A134ConAFIPMarcaRep ;
   private String AV13ConAFIPTipo ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private boolean Cond_result ;
   private String AV32ConDescrip ;
   private String AV33descuentoAdelantoVacConDescrip ;
   private String AV34descuVacDescrip ;
   private String[] aP17 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private String[] aP15 ;
   private String[] aP16 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JD2_A72AFIPConCod ;
}

final  class crearconceptoafipdefault3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JD2", "SELECT AFIPConCod FROM AFIPConcepto WHERE AFIPConCod = ( ?) ORDER BY AFIPConCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
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
               stmt.setString(1, (String)parms[0], 6);
               return;
      }
   }

}

