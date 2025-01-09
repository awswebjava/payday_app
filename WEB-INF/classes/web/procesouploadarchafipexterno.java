package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesouploadarchafipexterno extends GXProcedure
{
   public procesouploadarchafipexterno( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesouploadarchafipexterno.class ), "" );
   }

   public procesouploadarchafipexterno( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             short[] aP4 )
   {
      procesouploadarchafipexterno.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        short[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             short[] aP4 ,
                             String[] aP5 )
   {
      procesouploadarchafipexterno.this.AV12CliCod = aP0;
      procesouploadarchafipexterno.this.AV13EmpCod = aP1;
      procesouploadarchafipexterno.this.AV18ImpLiqSec = aP2;
      procesouploadarchafipexterno.this.aP3 = aP3;
      procesouploadarchafipexterno.this.aP4 = aP4;
      procesouploadarchafipexterno.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV55basicoConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesouploadarchafipexterno.this.AV55basicoConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV56basicoMensualConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesouploadarchafipexterno.this.AV56basicoMensualConCodigo = GXv_char1[0] ;
      GXv_char1[0] = AV57encodingPalabra ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.encoding_importar_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesouploadarchafipexterno.this.AV57encodingPalabra = GXv_char1[0] ;
      if ( (GXutil.strcmp("", AV57encodingPalabra)==0) )
      {
         AV57encodingPalabra = httpContext.getMessage( "UTF-8", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "encoding ", "")+AV57encodingPalabra) ;
      AV8vez = (short)(1) ;
      AV9seguir = true ;
      while ( ( AV8vez <= 2 ) && ( AV9seguir ) )
      {
         if ( AV10errores.size() > 0 )
         {
            if (true) break;
         }
         if ( AV8vez == 2 )
         {
            new web.eliminarimportacionconceptos(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV18ImpLiqSec, "") ;
         }
         AV10errores.clear();
         AV11ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         /* Using cursor P00N72 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Short.valueOf(AV18ImpLiqSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A88ImpLiqSec = P00N72_A88ImpLiqSec[0] ;
            A1EmpCod = P00N72_A1EmpCod[0] ;
            A3CliCod = P00N72_A3CliCod[0] ;
            A638ImpLiqConFileName = P00N72_A638ImpLiqConFileName[0] ;
            A639ImpLiqConFileType = P00N72_A639ImpLiqConFileType[0] ;
            A637ImpLiqConFile = P00N72_A637ImpLiqConFile[0] ;
            A658ImpLiqConFileNameAndType = P00N72_A658ImpLiqConFileNameAndType[0] ;
            AV16File.setSource( A637ImpLiqConFile );
            AV58destino = httpContext.getMessage( "temp/", "") + GXutil.trim( AV16File.getName()) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "copia a ", "")+AV58destino) ;
            AV16File.copy(AV58destino);
            AV50Result = context.getSessionInstances().getDelimitedFiles().dfropen( AV58destino, 0, "", "", AV57encodingPalabra) ;
            if ( AV50Result == 0 )
            {
               AV28f = (short)(0) ;
               while ( context.getSessionInstances().getDelimitedFiles().dfrnext( ) == 0 )
               {
                  AV28f = (short)(AV28f+1) ;
                  GXv_char1[0] = AV17fileLine ;
                  GXt_int2 = context.getSessionInstances().getDelimitedFiles().dfrgtxt( GXv_char1, (short)(999)) ;
                  AV17fileLine = GXv_char1[0] ;
                  AV51errorDfrgtxt = GXt_int2 ;
                  new web.msgdebug_prod(remoteHandle, context).execute( httpContext.getMessage( "&!fileLine ", "")+AV17fileLine, "") ;
                  AV27errorFormato = "" ;
                  AV19ImpLiqConAfipCod = GXutil.trim( GXutil.substring( AV17fileLine, 1, 6)) ;
                  AV20ImpLiqConExtCod = GXutil.trim( GXutil.substring( AV17fileLine, 7, 10)) ;
                  new web.msgdebug7(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "dsc ", "")+GXutil.trim( GXutil.substring( AV17fileLine, 17, 150))) ;
                  AV21ImpLiqConExtDescrip = GXutil.trim( GXutil.substring( AV17fileLine, 17, 150)) ;
                  AV45columna = (short)(167) ;
                  AV44ConAFIPMarcaRep = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  AV45columna = (short)(AV45columna+1) ;
                  AV29ImpLiqSIPAApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV29ImpLiqSIPAApo)==0) )
                  {
                     AV29ImpLiqSIPAApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV32ImpLiqSIPACont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV32ImpLiqSIPACont)==0) )
                  {
                     AV32ImpLiqSIPACont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV40ImpLiqINSSJyPApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV40ImpLiqINSSJyPApo)==0) )
                  {
                     AV40ImpLiqINSSJyPApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV33ImpLiqINSSJyPCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV33ImpLiqINSSJyPCont)==0) )
                  {
                     AV33ImpLiqINSSJyPCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV30ImpLiqObraSocApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV30ImpLiqObraSocApo)==0) )
                  {
                     AV30ImpLiqObraSocApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV34ImpLiqObraSocCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV34ImpLiqObraSocCont)==0) )
                  {
                     AV34ImpLiqObraSocCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV41ImpLiqFonSolRedApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV41ImpLiqFonSolRedApo)==0) )
                  {
                     AV41ImpLiqFonSolRedApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV35ImpLiqFonSolRedCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV35ImpLiqFonSolRedCont)==0) )
                  {
                     AV35ImpLiqFonSolRedCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV42ImpLiqRenateaApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV42ImpLiqRenateaApo)==0) )
                  {
                     AV42ImpLiqRenateaApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV36ImpLiqRenateaCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV36ImpLiqRenateaCont)==0) )
                  {
                     AV36ImpLiqRenateaCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV46libre1 = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  AV45columna = (short)(AV45columna+1) ;
                  AV37ImpLiqAsigFamCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV37ImpLiqAsigFamCont)==0) )
                  {
                     AV37ImpLiqAsigFamCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV47libre2 = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  AV45columna = (short)(AV45columna+1) ;
                  AV38ImpLiqFonNacEmpCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV38ImpLiqFonNacEmpCont)==0) )
                  {
                     AV38ImpLiqFonNacEmpCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV48libre3 = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  AV45columna = (short)(AV45columna+1) ;
                  AV39ImpLiqLeyRieTrabCont = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV39ImpLiqLeyRieTrabCont)==0) )
                  {
                     AV39ImpLiqLeyRieTrabCont = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV43ImpLiqRegDifApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV43ImpLiqRegDifApo)==0) )
                  {
                     AV43ImpLiqRegDifApo = "0" ;
                  }
                  AV45columna = (short)(AV45columna+1) ;
                  AV49libre4 = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  AV45columna = (short)(AV45columna+1) ;
                  AV31ImpLiqRegEspApo = GXutil.trim( GXutil.substring( AV17fileLine, AV45columna, 1)) ;
                  if ( (GXutil.strcmp("", AV31ImpLiqRegEspApo)==0) )
                  {
                     AV31ImpLiqRegEspApo = "0" ;
                  }
                  if ( AV8vez == 1 )
                  {
                     if ( (GXutil.strcmp("", AV19ImpLiqConAfipCod)==0) || (GXutil.strcmp("", AV20ImpLiqConExtCod)==0) || (GXutil.strcmp("", AV21ImpLiqConExtDescrip)==0) || (GXutil.strcmp("", AV44ConAFIPMarcaRep)==0) || (GXutil.strcmp("", AV29ImpLiqSIPAApo)==0) || (GXutil.strcmp("", AV30ImpLiqObraSocApo)==0) || (GXutil.strcmp("", AV31ImpLiqRegEspApo)==0) || (GXutil.strcmp("", AV40ImpLiqINSSJyPApo)==0) || (GXutil.strcmp("", AV41ImpLiqFonSolRedApo)==0) || (GXutil.strcmp("", AV42ImpLiqRenateaApo)==0) || (GXutil.strcmp("", AV43ImpLiqRegDifApo)==0) || (GXutil.strcmp("", AV32ImpLiqSIPACont)==0) || (GXutil.strcmp("", AV33ImpLiqINSSJyPCont)==0) || (GXutil.strcmp("", AV34ImpLiqObraSocCont)==0) || (GXutil.strcmp("", AV35ImpLiqFonSolRedCont)==0) || (GXutil.strcmp("", AV36ImpLiqRenateaCont)==0) || (GXutil.strcmp("", AV37ImpLiqAsigFamCont)==0) || (GXutil.strcmp("", AV38ImpLiqFonNacEmpCont)==0) || (GXutil.strcmp("", AV39ImpLiqLeyRieTrabCont)==0) )
                     {
                        if ( (GXutil.strcmp("", AV19ImpLiqConAfipCod)==0) || (GXutil.strcmp("", AV20ImpLiqConExtCod)==0) || (GXutil.strcmp("", AV21ImpLiqConExtDescrip)==0) )
                        {
                           if ( (GXutil.strcmp("", AV19ImpLiqConAfipCod)==0) )
                           {
                              AV27errorFormato = httpContext.getMessage( "Código de AFIP vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV20ImpLiqConExtCod)==0) )
                           {
                              AV27errorFormato += httpContext.getMessage( " Código de concepto vacío", "") ;
                           }
                           if ( (GXutil.strcmp("", AV21ImpLiqConExtDescrip)==0) )
                           {
                              AV27errorFormato += httpContext.getMessage( " Descripción vacía", "") ;
                           }
                        }
                        else
                        {
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 1 ", "") ;
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
                        GXv_boolean3[0] = AV25esNumero ;
                        new web.esnumero(remoteHandle, context).execute( AV19ImpLiqConAfipCod, GXv_boolean3) ;
                        procesouploadarchafipexterno.this.AV25esNumero = GXv_boolean3[0] ;
                        if ( ! AV25esNumero )
                        {
                           AV27errorFormato = httpContext.getMessage( "Código de AFIP inválido ", "") + AV19ImpLiqConAfipCod ;
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
                        GXv_boolean3[0] = AV25esNumero ;
                        new web.esnumero(remoteHandle, context).execute( AV21ImpLiqConExtDescrip, GXv_boolean3) ;
                        procesouploadarchafipexterno.this.AV25esNumero = GXv_boolean3[0] ;
                        if ( AV25esNumero )
                        {
                           AV27errorFormato = httpContext.getMessage( "Descripción inválida", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 2", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 3", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 4", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 5", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 6", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 7", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 8", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 9", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 10", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 11", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 12", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 13", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 14", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 15", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 16", "") ;
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
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 17", "") ;
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
                        if ( ( GXutil.strcmp(AV46libre1, " ") != 0 ) || ( GXutil.strcmp(AV47libre2, " ") != 0 ) || ( GXutil.strcmp(AV48libre3, " ") != 0 ) || ( GXutil.strcmp(AV49libre4, " ") != 0 ) )
                        {
                           AV27errorFormato = httpContext.getMessage( "Formato Inválido 18", "") ;
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
                     new web.grabaconceptoimportacion(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV18ImpLiqSec, AV20ImpLiqConExtCod, AV21ImpLiqConExtDescrip, AV19ImpLiqConAfipCod, AV31ImpLiqRegEspApo, AV43ImpLiqRegDifApo, AV42ImpLiqRenateaApo, AV41ImpLiqFonSolRedApo, AV30ImpLiqObraSocApo, AV40ImpLiqINSSJyPApo, AV29ImpLiqSIPAApo, AV39ImpLiqLeyRieTrabCont, AV38ImpLiqFonNacEmpCont, AV37ImpLiqAsigFamCont, AV36ImpLiqRenateaCont, AV35ImpLiqFonSolRedCont, AV34ImpLiqObraSocCont, AV33ImpLiqINSSJyPCont, AV32ImpLiqSIPACont, GXv_char1) ;
                     procesouploadarchafipexterno.this.AV53ImpLiqConSisCod = GXv_char1[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&ImpLiqConSisCod ", "")+AV53ImpLiqConSisCod+httpContext.getMessage( " basico ", "")+GXutil.trim( AV55basicoConCodigo)) ;
                     if ( ( GXutil.strcmp(AV53ImpLiqConSisCod, AV55basicoConCodigo) == 0 ) || ( GXutil.strcmp(AV53ImpLiqConSisCod, AV56basicoMensualConCodigo) == 0 ) )
                     {
                        AV54basicoHay = true ;
                     }
                     AV23altas = (short)(AV23altas+1) ;
                  }
               }
               AV52errorDfrclose = context.getSessionInstances().getDelimitedFiles().dfrclose( ) ;
            }
            else
            {
               AV10errores.add(httpContext.getMessage( "No se pudo abrir el archivo ", "")+GXutil.trim( A658ImpLiqConFileNameAndType)+" ("+GXutil.trim( GXutil.str( AV50Result, 4, 0))+")", 0);
            }
            if ( ( AV10errores.size() == 0 ) && ( AV8vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV10errores.size() > 0 ) && ( AV8vez == 1 ) )
               {
                  AV9seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV8vez = (short)(AV8vez+1) ;
      }
      if ( ( AV23altas > 0 ) && ! AV54basicoHay )
      {
         AV10errores.add(httpContext.getMessage( "No se pudo detectar concepto de sueldo básico", ""), 0);
      }
      if ( AV10errores.size() > 0 )
      {
         AV26e = (short)(1) ;
         AV10errores.sort("");
         while ( AV26e <= AV10errores.size() )
         {
            if ( GXutil.strcmp((String)AV10errores.elementAt(-1+AV26e), AV22ultiError) == 0 )
            {
               AV10errores.removeItem(AV26e);
            }
            else
            {
               AV22ultiError = (String)AV10errores.elementAt(-1+AV26e) ;
               AV26e = (short)(AV26e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV10errores.add(httpContext.getMessage( "Archivo con formato inválido (", "")+GXutil.trim( AV27errorFormato)+httpContext.getMessage( " en línea ", "")+GXutil.trim( GXutil.str( AV28f, 4, 0))+")", 0);
      new web.msgdebug7(remoteHandle, context).execute( AV61Pgmname, AV17fileLine) ;
   }

   protected void cleanup( )
   {
      this.aP3[0] = procesouploadarchafipexterno.this.AV10errores;
      this.aP4[0] = procesouploadarchafipexterno.this.AV23altas;
      this.aP5[0] = procesouploadarchafipexterno.this.AV58destino;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58destino = "" ;
      AV55basicoConCodigo = "" ;
      AV56basicoMensualConCodigo = "" ;
      AV57encodingPalabra = "" ;
      AV61Pgmname = "" ;
      AV11ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P00N72_A88ImpLiqSec = new short[1] ;
      P00N72_A1EmpCod = new short[1] ;
      P00N72_A3CliCod = new int[1] ;
      P00N72_A638ImpLiqConFileName = new String[] {""} ;
      P00N72_A639ImpLiqConFileType = new String[] {""} ;
      P00N72_A637ImpLiqConFile = new String[] {""} ;
      P00N72_A658ImpLiqConFileNameAndType = new String[] {""} ;
      A638ImpLiqConFileName = "" ;
      A639ImpLiqConFileType = "" ;
      A637ImpLiqConFile = "" ;
      A658ImpLiqConFileNameAndType = "" ;
      AV16File = new com.genexus.util.GXFile();
      AV17fileLine = "" ;
      AV27errorFormato = "" ;
      AV19ImpLiqConAfipCod = "" ;
      AV20ImpLiqConExtCod = "" ;
      AV21ImpLiqConExtDescrip = "" ;
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
      AV46libre1 = "" ;
      AV37ImpLiqAsigFamCont = "" ;
      AV47libre2 = "" ;
      AV38ImpLiqFonNacEmpCont = "" ;
      AV48libre3 = "" ;
      AV39ImpLiqLeyRieTrabCont = "" ;
      AV43ImpLiqRegDifApo = "" ;
      AV49libre4 = "" ;
      AV31ImpLiqRegEspApo = "" ;
      GXv_boolean3 = new boolean[1] ;
      AV53ImpLiqConSisCod = "" ;
      GXv_char1 = new String[1] ;
      AV22ultiError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procesouploadarchafipexterno__default(),
         new Object[] {
             new Object[] {
            P00N72_A88ImpLiqSec, P00N72_A1EmpCod, P00N72_A3CliCod, P00N72_A638ImpLiqConFileName, P00N72_A639ImpLiqConFileType, P00N72_A637ImpLiqConFile, P00N72_A658ImpLiqConFileNameAndType
            }
         }
      );
      AV61Pgmname = "ProcesoUploadArchAFIPExterno" ;
      /* GeneXus formulas. */
      AV61Pgmname = "ProcesoUploadArchAFIPExterno" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV18ImpLiqSec ;
   private short AV23altas ;
   private short AV8vez ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV50Result ;
   private short AV28f ;
   private short AV51errorDfrgtxt ;
   private short GXt_int2 ;
   private short AV45columna ;
   private short AV52errorDfrclose ;
   private short AV26e ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV55basicoConCodigo ;
   private String AV56basicoMensualConCodigo ;
   private String AV57encodingPalabra ;
   private String AV61Pgmname ;
   private String scmdbuf ;
   private String A639ImpLiqConFileType ;
   private String AV17fileLine ;
   private String AV19ImpLiqConAfipCod ;
   private String AV20ImpLiqConExtCod ;
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
   private String AV46libre1 ;
   private String AV37ImpLiqAsigFamCont ;
   private String AV47libre2 ;
   private String AV38ImpLiqFonNacEmpCont ;
   private String AV48libre3 ;
   private String AV39ImpLiqLeyRieTrabCont ;
   private String AV43ImpLiqRegDifApo ;
   private String AV49libre4 ;
   private String AV31ImpLiqRegEspApo ;
   private String AV53ImpLiqConSisCod ;
   private String GXv_char1[] ;
   private java.util.Date AV11ahora ;
   private boolean AV9seguir ;
   private boolean returnInSub ;
   private boolean AV25esNumero ;
   private boolean GXv_boolean3[] ;
   private boolean AV54basicoHay ;
   private String A637ImpLiqConFile ;
   private String AV58destino ;
   private String A638ImpLiqConFileName ;
   private String A658ImpLiqConFileNameAndType ;
   private String AV27errorFormato ;
   private String AV21ImpLiqConExtDescrip ;
   private String AV22ultiError ;
   private com.genexus.util.GXFile AV16File ;
   private String[] aP5 ;
   private GXSimpleCollection<String>[] aP3 ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00N72_A88ImpLiqSec ;
   private short[] P00N72_A1EmpCod ;
   private int[] P00N72_A3CliCod ;
   private String[] P00N72_A638ImpLiqConFileName ;
   private String[] P00N72_A639ImpLiqConFileType ;
   private String[] P00N72_A637ImpLiqConFile ;
   private String[] P00N72_A658ImpLiqConFileNameAndType ;
   private GXSimpleCollection<String> AV10errores ;
}

final  class procesouploadarchafipexterno__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00N72", "SELECT ImpLiqSec, EmpCod, CliCod, ImpLiqConFileName, ImpLiqConFileType, ImpLiqConFile, ImpLiqConFileNameAndType FROM importacion_liquidacion WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getBLOBFile(6, rslt.getString(5, 20), rslt.getVarchar(4));
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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

