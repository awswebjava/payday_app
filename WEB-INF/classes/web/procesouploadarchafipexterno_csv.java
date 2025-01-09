package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesouploadarchafipexterno_csv extends GXProcedure
{
   public procesouploadarchafipexterno_csv( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesouploadarchafipexterno_csv.class ), "" );
   }

   public procesouploadarchafipexterno_csv( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 ,
                            String aP3 ,
                            GXSimpleCollection<String>[] aP4 )
   {
      procesouploadarchafipexterno_csv.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             short[] aP5 )
   {
      procesouploadarchafipexterno_csv.this.AV11CliCod = aP0;
      procesouploadarchafipexterno_csv.this.AV13EmpCod = aP1;
      procesouploadarchafipexterno_csv.this.AV24ImpLiqSec = aP2;
      procesouploadarchafipexterno_csv.this.AV58destino = aP3;
      procesouploadarchafipexterno_csv.this.aP4 = aP4;
      procesouploadarchafipexterno_csv.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV55basicoConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesouploadarchafipexterno_csv.this.AV55basicoConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV56basicoMensualConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesouploadarchafipexterno_csv.this.AV56basicoMensualConCodigo = GXv_char1[0] ;
      AV57encodingPalabra = httpContext.getMessage( "UTF-8", "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "encoding ", "")+AV57encodingPalabra) ;
      AV28vez = (short)(1) ;
      AV25seguir = true ;
      while ( ( AV28vez <= 2 ) && ( AV25seguir ) )
      {
         if ( AV14errores.size() > 0 )
         {
            if (true) break;
         }
         if ( AV28vez == 2 )
         {
            new web.eliminarimportacionconceptos(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV24ImpLiqSec, "") ;
         }
         AV14errores.clear();
         AV9ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         /* Using cursor P025X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV13EmpCod), Short.valueOf(AV24ImpLiqSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A88ImpLiqSec = P025X2_A88ImpLiqSec[0] ;
            A1EmpCod = P025X2_A1EmpCod[0] ;
            A3CliCod = P025X2_A3CliCod[0] ;
            A658ImpLiqConFileNameAndType = P025X2_A658ImpLiqConFileNameAndType[0] ;
            AV50Result = context.getSessionInstances().getDelimitedFiles().dfropen( AV58destino, 0, "", "", AV57encodingPalabra) ;
            if ( AV50Result == 0 )
            {
               AV17f = (short)(0) ;
               while ( context.getSessionInstances().getDelimitedFiles().dfrnext( ) == 0 )
               {
                  AV17f = (short)(AV17f+1) ;
                  GXv_char1[0] = AV19fileLine ;
                  GXt_int2 = context.getSessionInstances().getDelimitedFiles().dfrgtxt( GXv_char1, (short)(999)) ;
                  AV19fileLine = GXv_char1[0] ;
                  AV51errorDfrgtxt = GXt_int2 ;
                  new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "&fileLine ", "")+AV19fileLine, "") ;
                  AV15errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "&f ", "")+GXutil.trim( GXutil.str( AV17f, 4, 0))) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "&fileLine ", "")+AV19fileLine) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "substr ", "")+GXutil.substring( AV19fileLine, 9, 11)) ;
                  if ( ( AV17f == 1 ) && ( GXutil.strcmp(GXutil.substring( AV19fileLine, 8, 11), httpContext.getMessage( "AFIP;Descri", "")) == 0 ) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "omite!", "")) ;
                  }
                  else
                  {
                     AV59split = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV19fileLine,";")) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "split count ", "")+GXutil.trim( GXutil.str( AV59split.size(), 9, 0))) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "&fileLine ", "")+AV19fileLine) ;
                     if ( AV59split.size() != 20 )
                     {
                        AV15errorFormato = httpContext.getMessage( "Deberían haber 20 columnas separadas por \";\" y hay ", "") + GXutil.trim( GXutil.str( AV59split.size(), 9, 0)) ;
                        /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                        S111 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        if (true) break;
                     }
                     AV20ImpLiqConAfipCod = GXutil.trim( (String)AV59split.elementAt(-1+1)) ;
                     AV21ImpLiqConExtCod = GXutil.trim( (String)AV59split.elementAt(-1+3)) ;
                     AV22ImpLiqConExtDescrip = GXutil.trim( (String)AV59split.elementAt(-1+4)) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "resultado de split &split.Item(4).Trim() ", "")+GXutil.trim( (String)AV59split.elementAt(-1+4))+" "+GXutil.trim( AV22ImpLiqConExtDescrip)) ;
                     AV44ConAFIPMarcaRep = GXutil.trim( (String)AV59split.elementAt(-1+5)) ;
                     AV29ImpLiqSIPAApo = GXutil.trim( (String)AV59split.elementAt(-1+6)) ;
                     if ( (GXutil.strcmp("", AV29ImpLiqSIPAApo)==0) )
                     {
                        AV29ImpLiqSIPAApo = "0" ;
                     }
                     AV32ImpLiqSIPACont = GXutil.trim( (String)AV59split.elementAt(-1+7)) ;
                     if ( (GXutil.strcmp("", AV32ImpLiqSIPACont)==0) )
                     {
                        AV32ImpLiqSIPACont = "0" ;
                     }
                     AV40ImpLiqINSSJyPApo = GXutil.trim( (String)AV59split.elementAt(-1+8)) ;
                     if ( (GXutil.strcmp("", AV40ImpLiqINSSJyPApo)==0) )
                     {
                        AV40ImpLiqINSSJyPApo = "0" ;
                     }
                     AV33ImpLiqINSSJyPCont = GXutil.trim( (String)AV59split.elementAt(-1+9)) ;
                     if ( (GXutil.strcmp("", AV33ImpLiqINSSJyPCont)==0) )
                     {
                        AV33ImpLiqINSSJyPCont = "0" ;
                     }
                     AV30ImpLiqObraSocApo = GXutil.trim( (String)AV59split.elementAt(-1+10)) ;
                     if ( (GXutil.strcmp("", AV30ImpLiqObraSocApo)==0) )
                     {
                        AV30ImpLiqObraSocApo = "0" ;
                     }
                     AV34ImpLiqObraSocCont = GXutil.trim( (String)AV59split.elementAt(-1+11)) ;
                     if ( (GXutil.strcmp("", AV34ImpLiqObraSocCont)==0) )
                     {
                        AV34ImpLiqObraSocCont = "0" ;
                     }
                     AV41ImpLiqFonSolRedApo = GXutil.trim( (String)AV59split.elementAt(-1+12)) ;
                     if ( (GXutil.strcmp("", AV41ImpLiqFonSolRedApo)==0) )
                     {
                        AV41ImpLiqFonSolRedApo = "0" ;
                     }
                     AV35ImpLiqFonSolRedCont = GXutil.trim( (String)AV59split.elementAt(-1+13)) ;
                     if ( (GXutil.strcmp("", AV35ImpLiqFonSolRedCont)==0) )
                     {
                        AV35ImpLiqFonSolRedCont = "0" ;
                     }
                     AV42ImpLiqRenateaApo = GXutil.trim( (String)AV59split.elementAt(-1+14)) ;
                     if ( (GXutil.strcmp("", AV42ImpLiqRenateaApo)==0) )
                     {
                        AV42ImpLiqRenateaApo = "0" ;
                     }
                     AV36ImpLiqRenateaCont = GXutil.trim( (String)AV59split.elementAt(-1+15)) ;
                     if ( (GXutil.strcmp("", AV36ImpLiqRenateaCont)==0) )
                     {
                        AV36ImpLiqRenateaCont = "0" ;
                     }
                     AV37ImpLiqAsigFamCont = GXutil.trim( (String)AV59split.elementAt(-1+16)) ;
                     if ( (GXutil.strcmp("", AV37ImpLiqAsigFamCont)==0) )
                     {
                        AV37ImpLiqAsigFamCont = "0" ;
                     }
                     AV38ImpLiqFonNacEmpCont = GXutil.trim( (String)AV59split.elementAt(-1+17)) ;
                     if ( (GXutil.strcmp("", AV38ImpLiqFonNacEmpCont)==0) )
                     {
                        AV38ImpLiqFonNacEmpCont = "0" ;
                     }
                     AV39ImpLiqLeyRieTrabCont = GXutil.trim( (String)AV59split.elementAt(-1+18)) ;
                     if ( (GXutil.strcmp("", AV39ImpLiqLeyRieTrabCont)==0) )
                     {
                        AV39ImpLiqLeyRieTrabCont = "0" ;
                     }
                     AV43ImpLiqRegDifApo = GXutil.trim( (String)AV59split.elementAt(-1+19)) ;
                     if ( (GXutil.strcmp("", AV43ImpLiqRegDifApo)==0) )
                     {
                        AV43ImpLiqRegDifApo = "0" ;
                     }
                     AV31ImpLiqRegEspApo = GXutil.trim( (String)AV59split.elementAt(-1+20)) ;
                     if ( (GXutil.strcmp("", AV31ImpLiqRegEspApo)==0) )
                     {
                        AV31ImpLiqRegEspApo = "0" ;
                     }
                     if ( AV28vez == 1 )
                     {
                        if ( (GXutil.strcmp("", AV20ImpLiqConAfipCod)==0) || (GXutil.strcmp("", AV21ImpLiqConExtCod)==0) || (GXutil.strcmp("", AV22ImpLiqConExtDescrip)==0) || (GXutil.strcmp("", AV44ConAFIPMarcaRep)==0) || (GXutil.strcmp("", AV29ImpLiqSIPAApo)==0) || (GXutil.strcmp("", AV30ImpLiqObraSocApo)==0) || (GXutil.strcmp("", AV31ImpLiqRegEspApo)==0) || (GXutil.strcmp("", AV40ImpLiqINSSJyPApo)==0) || (GXutil.strcmp("", AV41ImpLiqFonSolRedApo)==0) || (GXutil.strcmp("", AV42ImpLiqRenateaApo)==0) || (GXutil.strcmp("", AV43ImpLiqRegDifApo)==0) || (GXutil.strcmp("", AV32ImpLiqSIPACont)==0) || (GXutil.strcmp("", AV33ImpLiqINSSJyPCont)==0) || (GXutil.strcmp("", AV34ImpLiqObraSocCont)==0) || (GXutil.strcmp("", AV35ImpLiqFonSolRedCont)==0) || (GXutil.strcmp("", AV36ImpLiqRenateaCont)==0) || (GXutil.strcmp("", AV37ImpLiqAsigFamCont)==0) || (GXutil.strcmp("", AV38ImpLiqFonNacEmpCont)==0) || (GXutil.strcmp("", AV39ImpLiqLeyRieTrabCont)==0) )
                        {
                           if ( (GXutil.strcmp("", AV20ImpLiqConAfipCod)==0) || (GXutil.strcmp("", AV21ImpLiqConExtCod)==0) || (GXutil.strcmp("", AV22ImpLiqConExtDescrip)==0) )
                           {
                              if ( (GXutil.strcmp("", AV20ImpLiqConAfipCod)==0) )
                              {
                                 AV15errorFormato = httpContext.getMessage( "Código de AFIP vacío.", "") ;
                              }
                              if ( (GXutil.strcmp("", AV21ImpLiqConExtCod)==0) )
                              {
                                 AV15errorFormato += httpContext.getMessage( " Código de concepto vacío", "") ;
                              }
                              if ( (GXutil.strcmp("", AV22ImpLiqConExtDescrip)==0) )
                              {
                                 AV15errorFormato += httpContext.getMessage( " Descripción vacía", "") ;
                              }
                           }
                           else
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 1 ", "") ;
                           }
                           /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                           S111 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           if (true) break;
                        }
                        else
                        {
                           GXv_boolean3[0] = AV16esNumero ;
                           new web.esnumero(remoteHandle, context).execute( AV20ImpLiqConAfipCod, GXv_boolean3) ;
                           procesouploadarchafipexterno_csv.this.AV16esNumero = GXv_boolean3[0] ;
                           if ( ! AV16esNumero )
                           {
                              AV15errorFormato = httpContext.getMessage( "Código de AFIP inválido \"", "") + GXutil.trim( AV20ImpLiqConAfipCod) + "\"" ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           GXv_boolean3[0] = AV16esNumero ;
                           new web.esnumero(remoteHandle, context).execute( AV22ImpLiqConExtDescrip, GXv_boolean3) ;
                           procesouploadarchafipexterno_csv.this.AV16esNumero = GXv_boolean3[0] ;
                           if ( AV16esNumero )
                           {
                              AV15errorFormato = httpContext.getMessage( "Descripción inválida", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV44ConAFIPMarcaRep), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV44ConAFIPMarcaRep), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 2", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV29ImpLiqSIPAApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV29ImpLiqSIPAApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 3", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV30ImpLiqObraSocApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV30ImpLiqObraSocApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 4", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV31ImpLiqRegEspApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV31ImpLiqRegEspApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 5", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV40ImpLiqINSSJyPApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV40ImpLiqINSSJyPApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 6", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV41ImpLiqFonSolRedApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV41ImpLiqFonSolRedApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 7", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV42ImpLiqRenateaApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV42ImpLiqRenateaApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 8", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV43ImpLiqRegDifApo), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV43ImpLiqRegDifApo), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 9", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV32ImpLiqSIPACont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV32ImpLiqSIPACont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 10", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV34ImpLiqObraSocCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV34ImpLiqObraSocCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 11", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV33ImpLiqINSSJyPCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV33ImpLiqINSSJyPCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 12", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV35ImpLiqFonSolRedCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV35ImpLiqFonSolRedCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 13", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV36ImpLiqRenateaCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV36ImpLiqRenateaCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 14", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV37ImpLiqAsigFamCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV37ImpLiqAsigFamCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 15", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV38ImpLiqFonNacEmpCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV38ImpLiqFonNacEmpCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 16", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ( GXutil.strcmp(GXutil.trim( AV39ImpLiqLeyRieTrabCont), "0") != 0 ) && ( GXutil.strcmp(GXutil.trim( AV39ImpLiqLeyRieTrabCont), "1") != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Formato Inválido 17", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                        }
                     }
                     else
                     {
                        GXv_char1[0] = AV53ImpLiqConSisCod ;
                        new web.grabaconceptoimportacion(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV24ImpLiqSec, AV21ImpLiqConExtCod, AV22ImpLiqConExtDescrip, AV20ImpLiqConAfipCod, AV31ImpLiqRegEspApo, AV43ImpLiqRegDifApo, AV42ImpLiqRenateaApo, AV41ImpLiqFonSolRedApo, AV30ImpLiqObraSocApo, AV40ImpLiqINSSJyPApo, AV29ImpLiqSIPAApo, AV39ImpLiqLeyRieTrabCont, AV38ImpLiqFonNacEmpCont, AV37ImpLiqAsigFamCont, AV36ImpLiqRenateaCont, AV35ImpLiqFonSolRedCont, AV34ImpLiqObraSocCont, AV33ImpLiqINSSJyPCont, AV32ImpLiqSIPACont, GXv_char1) ;
                        procesouploadarchafipexterno_csv.this.AV53ImpLiqConSisCod = GXv_char1[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV63Pgmname, httpContext.getMessage( "&ImpLiqConSisCod ", "")+AV53ImpLiqConSisCod+httpContext.getMessage( " basico ", "")+GXutil.trim( AV55basicoConCodigo)) ;
                        if ( ( GXutil.strcmp(AV53ImpLiqConSisCod, AV55basicoConCodigo) == 0 ) || ( GXutil.strcmp(AV53ImpLiqConSisCod, AV56basicoMensualConCodigo) == 0 ) )
                        {
                           AV54basicoHay = true ;
                        }
                        AV10altas = (short)(AV10altas+1) ;
                     }
                  }
               }
               AV52errorDfrclose = context.getSessionInstances().getDelimitedFiles().dfrclose( ) ;
            }
            else
            {
               AV14errores.add(httpContext.getMessage( "No se pudo abrir el archivo ", "")+GXutil.trim( A658ImpLiqConFileNameAndType)+" ("+GXutil.trim( GXutil.str( AV50Result, 4, 0))+")", 0);
            }
            if ( ( AV14errores.size() == 0 ) && ( AV28vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV14errores.size() > 0 ) && ( AV28vez == 1 ) )
               {
                  AV25seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV28vez = (short)(AV28vez+1) ;
      }
      if ( ( AV10altas > 0 ) && ! AV54basicoHay )
      {
         AV14errores.add(httpContext.getMessage( "No se pudo detectar concepto de sueldo básico", ""), 0);
      }
      if ( AV14errores.size() > 0 )
      {
         AV12e = (short)(1) ;
         AV14errores.sort("");
         while ( AV12e <= AV14errores.size() )
         {
            if ( GXutil.strcmp((String)AV14errores.elementAt(-1+AV12e), AV8ultiError) == 0 )
            {
               AV14errores.removeItem(AV12e);
            }
            else
            {
               AV8ultiError = (String)AV14errores.elementAt(-1+AV12e) ;
               AV12e = (short)(AV12e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV14errores.add(httpContext.getMessage( "Archivo con formato inválido (", "")+GXutil.trim( AV15errorFormato)+httpContext.getMessage( " en línea ", "")+GXutil.trim( GXutil.str( AV17f, 4, 0))+")", 0);
      new web.msgdebug7(remoteHandle, context).execute( AV63Pgmname, AV19fileLine) ;
   }

   protected void cleanup( )
   {
      this.aP4[0] = procesouploadarchafipexterno_csv.this.AV14errores;
      this.aP5[0] = procesouploadarchafipexterno_csv.this.AV10altas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55basicoConCodigo = "" ;
      AV56basicoMensualConCodigo = "" ;
      AV57encodingPalabra = "" ;
      AV63Pgmname = "" ;
      AV9ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P025X2_A88ImpLiqSec = new short[1] ;
      P025X2_A1EmpCod = new short[1] ;
      P025X2_A3CliCod = new int[1] ;
      P025X2_A658ImpLiqConFileNameAndType = new String[] {""} ;
      A658ImpLiqConFileNameAndType = "" ;
      AV19fileLine = "" ;
      AV15errorFormato = "" ;
      AV59split = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20ImpLiqConAfipCod = "" ;
      AV21ImpLiqConExtCod = "" ;
      AV22ImpLiqConExtDescrip = "" ;
      AV44ConAFIPMarcaRep = "" ;
      AV29ImpLiqSIPAApo = "" ;
      AV32ImpLiqSIPACont = "" ;
      AV40ImpLiqINSSJyPApo = "" ;
      AV33ImpLiqINSSJyPCont = "" ;
      AV30ImpLiqObraSocApo = "" ;
      AV34ImpLiqObraSocCont = "" ;
      AV41ImpLiqFonSolRedApo = "" ;
      AV35ImpLiqFonSolRedCont = "" ;
      AV42ImpLiqRenateaApo = "" ;
      AV36ImpLiqRenateaCont = "" ;
      AV37ImpLiqAsigFamCont = "" ;
      AV38ImpLiqFonNacEmpCont = "" ;
      AV39ImpLiqLeyRieTrabCont = "" ;
      AV43ImpLiqRegDifApo = "" ;
      AV31ImpLiqRegEspApo = "" ;
      GXv_boolean3 = new boolean[1] ;
      AV53ImpLiqConSisCod = "" ;
      GXv_char1 = new String[1] ;
      AV8ultiError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procesouploadarchafipexterno_csv__default(),
         new Object[] {
             new Object[] {
            P025X2_A88ImpLiqSec, P025X2_A1EmpCod, P025X2_A3CliCod, P025X2_A658ImpLiqConFileNameAndType
            }
         }
      );
      AV63Pgmname = "ProcesoUploadArchAFIPExterno_CSV" ;
      /* GeneXus formulas. */
      AV63Pgmname = "ProcesoUploadArchAFIPExterno_CSV" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV24ImpLiqSec ;
   private short AV10altas ;
   private short AV28vez ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV50Result ;
   private short AV17f ;
   private short AV51errorDfrgtxt ;
   private short GXt_int2 ;
   private short AV52errorDfrclose ;
   private short AV12e ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV55basicoConCodigo ;
   private String AV56basicoMensualConCodigo ;
   private String AV57encodingPalabra ;
   private String AV63Pgmname ;
   private String scmdbuf ;
   private String AV19fileLine ;
   private String AV20ImpLiqConAfipCod ;
   private String AV21ImpLiqConExtCod ;
   private String AV44ConAFIPMarcaRep ;
   private String AV29ImpLiqSIPAApo ;
   private String AV32ImpLiqSIPACont ;
   private String AV40ImpLiqINSSJyPApo ;
   private String AV33ImpLiqINSSJyPCont ;
   private String AV30ImpLiqObraSocApo ;
   private String AV34ImpLiqObraSocCont ;
   private String AV41ImpLiqFonSolRedApo ;
   private String AV35ImpLiqFonSolRedCont ;
   private String AV42ImpLiqRenateaApo ;
   private String AV36ImpLiqRenateaCont ;
   private String AV37ImpLiqAsigFamCont ;
   private String AV38ImpLiqFonNacEmpCont ;
   private String AV39ImpLiqLeyRieTrabCont ;
   private String AV43ImpLiqRegDifApo ;
   private String AV31ImpLiqRegEspApo ;
   private String AV53ImpLiqConSisCod ;
   private String GXv_char1[] ;
   private java.util.Date AV9ahora ;
   private boolean AV25seguir ;
   private boolean returnInSub ;
   private boolean AV16esNumero ;
   private boolean GXv_boolean3[] ;
   private boolean AV54basicoHay ;
   private String AV58destino ;
   private String A658ImpLiqConFileNameAndType ;
   private String AV15errorFormato ;
   private String AV22ImpLiqConExtDescrip ;
   private String AV8ultiError ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P025X2_A88ImpLiqSec ;
   private short[] P025X2_A1EmpCod ;
   private int[] P025X2_A3CliCod ;
   private String[] P025X2_A658ImpLiqConFileNameAndType ;
   private GXSimpleCollection<String> AV59split ;
   private GXSimpleCollection<String> AV14errores ;
}

final  class procesouploadarchafipexterno_csv__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025X2", "SELECT ImpLiqSec, EmpCod, CliCod, ImpLiqConFileNameAndType FROM importacion_liquidacion WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

