package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaopecli2 extends GXProcedure
{
   public grabaopecli2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaopecli2.class ), "" );
   }

   public grabaopecli2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        java.util.Date aP8 ,
                        boolean aP9 ,
                        boolean aP10 ,
                        boolean aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             boolean aP11 )
   {
      grabaopecli2.this.AV10CliCod = aP0;
      grabaopecli2.this.AV15parmOpeCliId = aP1;
      grabaopecli2.this.AV16oldOpeCliCodFormula = aP2;
      grabaopecli2.this.AV14OpeCliCodFormula = aP3;
      grabaopecli2.this.AV11OpeCliDescrip = aP4;
      grabaopecli2.this.AV9OpeCliValor = aP5;
      grabaopecli2.this.AV13variable = aP6;
      grabaopecli2.this.AV18OpeCliVig = aP7;
      grabaopecli2.this.AV24OpeCliVRetro = aP8;
      grabaopecli2.this.AV21minusculas = aP9;
      grabaopecli2.this.AV22OpeCliEsCant = aP10;
      grabaopecli2.this.AV23OpeCliAliEs = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&OpeCliCodFormula ", "")+GXutil.trim( AV14OpeCliCodFormula)+httpContext.getMessage( " &OpeCliEsCant ", "")+GXutil.trim( GXutil.booltostr( AV22OpeCliEsCant))) ;
      AV29GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV15parmOpeCliId ,
                                           A82OpeCliId ,
                                           A549OpeCliCodFormula ,
                                           AV14OpeCliCodFormula ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01132 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV15parmOpeCliId, AV14OpeCliCodFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A549OpeCliCodFormula = P01132_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P01132_A82OpeCliId[0] ;
         A3CliCod = P01132_A3CliCod[0] ;
         A536OpeCliIdMay = P01132_A536OpeCliIdMay[0] ;
         A534OpeCliDescrip = P01132_A534OpeCliDescrip[0] ;
         AV29GXLvl2 = (byte)(1) ;
         A534OpeCliDescrip = AV11OpeCliDescrip ;
         A549OpeCliCodFormula = AV14OpeCliCodFormula ;
         AV8OpeCliId = A82OpeCliId ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "entra ", "")+httpContext.getMessage( " &OpeCliEsCant ", "")+GXutil.trim( GXutil.booltostr( AV22OpeCliEsCant))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01133 */
         pr_default.execute(1, new Object[] {A549OpeCliCodFormula, A534OpeCliDescrip, Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         if (true) break;
         /* Using cursor P01134 */
         pr_default.execute(2, new Object[] {A549OpeCliCodFormula, A534OpeCliDescrip, Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV29GXLvl2 == 0 )
      {
         AV12OpeCliIdMay = GXutil.upper( GXutil.trim( AV14OpeCliCodFormula)) ;
         GXv_char1[0] = AV12OpeCliIdMay ;
         new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
         grabaopecli2.this.AV12OpeCliIdMay = GXv_char1[0] ;
         AV12OpeCliIdMay = GXutil.strReplace( AV12OpeCliIdMay, " X", "") ;
         new web.msgdebug7(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "(&OpeCliIdMay ", "")+AV12OpeCliIdMay) ;
         if ( ! (GXutil.strcmp("", AV15parmOpeCliId)==0) )
         {
            AV8OpeCliId = AV15parmOpeCliId ;
         }
         else
         {
            GXv_char1[0] = AV8OpeCliId ;
            new web.newcodigoopecliid(remoteHandle, context).execute( AV10CliCod, GXutil.lower( AV12OpeCliIdMay), GXv_char1) ;
            grabaopecli2.this.AV8OpeCliId = GXv_char1[0] ;
         }
         /*
            INSERT RECORD ON TABLE Variable

         */
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "ini graba ", "")+httpContext.getMessage( " &OpeCliEsCant ", "")+GXutil.trim( GXutil.booltostr( AV22OpeCliEsCant))) ;
         A3CliCod = AV10CliCod ;
         A82OpeCliId = AV8OpeCliId ;
         AV20OpeCliCodFormulaAux = AV14OpeCliCodFormula ;
         if ( GXutil.strcmp(AV8OpeCliId, "[gan_escala]") == 0 )
         {
            AV20OpeCliCodFormulaAux = GXutil.strReplace( AV20OpeCliCodFormulaAux, "[", "{") ;
            AV20OpeCliCodFormulaAux = GXutil.strReplace( AV20OpeCliCodFormulaAux, "]", "}") ;
         }
         if ( AV21minusculas )
         {
            A549OpeCliCodFormula = GXutil.lower( AV20OpeCliCodFormulaAux) ;
         }
         else
         {
            A549OpeCliCodFormula = AV20OpeCliCodFormulaAux ;
         }
         A534OpeCliDescrip = AV11OpeCliDescrip ;
         A536OpeCliIdMay = AV12OpeCliIdMay ;
         GXt_char2 = A544OpeCliUsuCre ;
         GXv_char1[0] = GXt_char2 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char1) ;
         grabaopecli2.this.GXt_char2 = GXv_char1[0] ;
         A544OpeCliUsuCre = GXt_char2 ;
         A545OpeCliFecCre = GXutil.serverDate( context, remoteHandle, pr_default) ;
         if ( ( GXutil.strcmp(AV8OpeCliId, "[apo_jub_ali]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[apo_OS_ali]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[apo_INSSJyP_ali]") == 0 ) )
         {
            A741OpeCLiAliLey = true ;
            A1913VarFrecAct = (byte)(0) ;
         }
         else
         {
            A741OpeCLiAliLey = false ;
            if ( GXutil.strcmp(AV8OpeCliId, "[ded_esp_inc_tabla]") == 0 )
            {
               A1913VarFrecAct = (byte)(0) ;
            }
            else if ( ( GXutil.strcmp(AV8OpeCliId, "[base_imp_max]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[base_imp_min]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_solteros]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_casados]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_SAC]") == 0 ) )
            {
               A1913VarFrecAct = (byte)(3) ;
            }
            else if ( ( GXutil.strcmp(AV8OpeCliId, "[smvm]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[fijo_ART]") == 0 ) )
            {
               A1913VarFrecAct = (byte)(1) ;
            }
            else
            {
               if ( AV23OpeCliAliEs )
               {
                  A1913VarFrecAct = (byte)(0) ;
               }
               else
               {
                  A1913VarFrecAct = (byte)(12) ;
               }
            }
         }
         A931OpeCliEsCant = AV22OpeCliEsCant ;
         A934OpeCliAliEs = AV23OpeCliAliEs ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "fin graba ", "")+httpContext.getMessage( " &OpeCliEsCant ", "")+GXutil.trim( GXutil.booltostr( AV22OpeCliEsCant))) ;
         if ( ! AV23OpeCliAliEs )
         {
            if ( ( GXutil.strcmp(AV8OpeCliId, "[gan_escala]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_SAC]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_solteros]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[piso_ganancias_casados]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[ded_esp_inc_tabla]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[importe_a_detraer_default]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[svc_Fijo]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[tope_bonos]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[tope_seguros]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[tope_hipoteca]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[tope_sepelio]") == 0 ) )
            {
               A1910VarBaseURL = "" ;
               n1910VarBaseURL = false ;
            }
            else
            {
               if ( ( GXutil.strcmp(AV8OpeCliId, "[base_imp_max]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[base_imp_min]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[smvm]") == 0 ) )
               {
                  A1910VarBaseURL = httpContext.getMessage( "https://www.boletinoficial.gob.ar/", "") ;
                  n1910VarBaseURL = false ;
                  A1911VarScrapTDoc = "HTML" ;
                  n1911VarScrapTDoc = false ;
               }
               else
               {
                  if ( GXutil.strcmp(AV8OpeCliId, "[fijo_ART]") == 0 )
                  {
                     A1910VarBaseURL = httpContext.getMessage( "https://www.boletinoficial.gob.ar/", "") ;
                     n1910VarBaseURL = false ;
                     A1911VarScrapTDoc = "HTML" ;
                     n1911VarScrapTDoc = false ;
                  }
                  else
                  {
                     A1910VarBaseURL = httpContext.getMessage( "https://www.afip.gob.ar/", "") ;
                     n1910VarBaseURL = false ;
                     A1911VarScrapTDoc = "PDF" ;
                     n1911VarScrapTDoc = false ;
                  }
               }
            }
            if ( GXutil.strcmp(AV8OpeCliId, "[fijo_ART]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "disposición %anterior(m/aaaa) SUPERINTENDENCIA DE RIESGOS DEL TRABAJO", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "por lo que la suma fija prevista en ", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Texto" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = httpContext.getMessage( "para ambos regímenes", "") ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[base_imp_max]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "%aaaa Base imponible máxima %m", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "ARTÍCULO 3°.- ", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Texto" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = httpContext.getMessage( "ARTÍCULO ", "") ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[base_imp_min]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "%aaaa Base imponible mínima %m", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "ARTÍCULO 3", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Texto" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = httpContext.getMessage( "ARTÍCULO ", "") ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[smvm]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "salario mínimo vital y movil a partir del 1° de %m de %aaaa Resolución", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "A partir del 1° de %m de %aaaa", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Texto" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = httpContext.getMessage( "ART", "") ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[ded_cony]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Deducciones personales para el período fiscal %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "1. Cónyuge", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[ded_especial]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Deducciones personales para el período fiscal %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "Deducción Especial [Artículo 30, inciso c), Apartado 2]", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[ded_hijo]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Deducciones personales para el período fiscal %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "2. Hijo", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[ded_hijo_incap]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Deducciones personales para el período fiscal %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "2.1. Hijo incapacitado para el trabajo", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[mni]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Deducciones personales para el período fiscal %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "Ganancias no imponibles [Artículo 30, inciso a)]", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
            else if ( GXutil.strcmp(AV8OpeCliId, "[gan_escala]") == 0 )
            {
               A1908VarBusGoogle = httpContext.getMessage( "Ganancias tramos de escala %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = httpContext.getMessage( "Período %aaaa", "") ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Texto" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = httpContext.getMessage( "Personas Humanas", "") ;
               n1921VarScrapFin = false ;
            }
            else
            {
               A1908VarBusGoogle = GXutil.trim( A534OpeCliDescrip) + httpContext.getMessage( " %m %aaaa", "") ;
               n1908VarBusGoogle = false ;
               A1909VarBusWeb = GXutil.trim( A534OpeCliDescrip) ;
               n1909VarBusWeb = false ;
               A1912VarScrapTipo = "Tabla" ;
               n1912VarScrapTipo = false ;
               A1921VarScrapFin = "" ;
               n1921VarScrapFin = false ;
            }
         }
         if ( AV23OpeCliAliEs )
         {
            A2129VarActObl = false ;
         }
         else
         {
            A2129VarActObl = true ;
         }
         A2139VarHelp = httpContext.getMessage( "Ayuda/Documentación (me falta completar)", "") ;
         A2011VarRelRef = "" ;
         A2025VarOld = "" ;
         A2140VarDetail = "" ;
         /* Using cursor P01135 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A549OpeCliCodFormula, A534OpeCliDescrip, A536OpeCliIdMay, A544OpeCliUsuCre, A545OpeCliFecCre, Boolean.valueOf(A741OpeCLiAliLey), Boolean.valueOf(A931OpeCliEsCant), Boolean.valueOf(A934OpeCliAliEs), Boolean.valueOf(n1908VarBusGoogle), A1908VarBusGoogle, Boolean.valueOf(n1909VarBusWeb), A1909VarBusWeb, Boolean.valueOf(n1910VarBaseURL), A1910VarBaseURL, Boolean.valueOf(n1911VarScrapTDoc), A1911VarScrapTDoc, Boolean.valueOf(n1912VarScrapTipo), A1912VarScrapTipo, Byte.valueOf(A1913VarFrecAct), Boolean.valueOf(n1921VarScrapFin), A1921VarScrapFin, A2011VarRelRef, A2025VarOld, Boolean.valueOf(A2129VarActObl), A2139VarHelp, A2140VarDetail});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      if ( (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         AV8OpeCliId = AV15parmOpeCliId ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18OpeCliVig)) )
      {
         AV19auxOpeCliVig = GXutil.serverDate( context, remoteHandle, pr_default) ;
      }
      else
      {
         AV19auxOpeCliVig = AV18OpeCliVig ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "ini graba valor ", "")) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV19auxOpeCliVig, AV24OpeCliVRetro, false, AV9OpeCliValor, 0, 0) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "fin graba valor ", "")) ;
      new web.formulapropagarconstante(remoteHandle, context).execute( AV10CliCod, (short)(1), AV16oldOpeCliCodFormula, AV14OpeCliCodFormula) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaopecli2");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28Pgmname = "" ;
      scmdbuf = "" ;
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      P01132_A549OpeCliCodFormula = new String[] {""} ;
      P01132_A82OpeCliId = new String[] {""} ;
      P01132_A3CliCod = new int[1] ;
      P01132_A536OpeCliIdMay = new String[] {""} ;
      P01132_A534OpeCliDescrip = new String[] {""} ;
      A536OpeCliIdMay = "" ;
      A534OpeCliDescrip = "" ;
      AV8OpeCliId = "" ;
      AV12OpeCliIdMay = "" ;
      AV20OpeCliCodFormulaAux = "" ;
      A544OpeCliUsuCre = "" ;
      GXt_char2 = "" ;
      GXv_char1 = new String[1] ;
      A545OpeCliFecCre = GXutil.nullDate() ;
      A1910VarBaseURL = "" ;
      A1911VarScrapTDoc = "" ;
      A1908VarBusGoogle = "" ;
      A1909VarBusWeb = "" ;
      A1912VarScrapTipo = "" ;
      A1921VarScrapFin = "" ;
      A2139VarHelp = "" ;
      A2011VarRelRef = "" ;
      A2025VarOld = "" ;
      A2140VarDetail = "" ;
      Gx_emsg = "" ;
      AV19auxOpeCliVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaopecli2__default(),
         new Object[] {
             new Object[] {
            P01132_A549OpeCliCodFormula, P01132_A82OpeCliId, P01132_A3CliCod, P01132_A536OpeCliIdMay, P01132_A534OpeCliDescrip
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV28Pgmname = "GrabaOpeCli2" ;
      /* GeneXus formulas. */
      AV28Pgmname = "GrabaOpeCli2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV29GXLvl2 ;
   private byte A1913VarFrecAct ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int GX_INS71 ;
   private String AV15parmOpeCliId ;
   private String AV16oldOpeCliCodFormula ;
   private String AV14OpeCliCodFormula ;
   private String AV13variable ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String A536OpeCliIdMay ;
   private String AV8OpeCliId ;
   private String AV12OpeCliIdMay ;
   private String AV20OpeCliCodFormulaAux ;
   private String GXt_char2 ;
   private String GXv_char1[] ;
   private String A1911VarScrapTDoc ;
   private String A1912VarScrapTipo ;
   private String Gx_emsg ;
   private java.util.Date AV18OpeCliVig ;
   private java.util.Date AV24OpeCliVRetro ;
   private java.util.Date A545OpeCliFecCre ;
   private java.util.Date AV19auxOpeCliVig ;
   private boolean AV21minusculas ;
   private boolean AV22OpeCliEsCant ;
   private boolean AV23OpeCliAliEs ;
   private boolean A741OpeCLiAliLey ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean n1910VarBaseURL ;
   private boolean n1911VarScrapTDoc ;
   private boolean n1908VarBusGoogle ;
   private boolean n1909VarBusWeb ;
   private boolean n1912VarScrapTipo ;
   private boolean n1921VarScrapFin ;
   private boolean A2129VarActObl ;
   private String AV9OpeCliValor ;
   private String A2139VarHelp ;
   private String A2025VarOld ;
   private String AV11OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private String A544OpeCliUsuCre ;
   private String A1910VarBaseURL ;
   private String A1908VarBusGoogle ;
   private String A1909VarBusWeb ;
   private String A1921VarScrapFin ;
   private String A2011VarRelRef ;
   private String A2140VarDetail ;
   private IDataStoreProvider pr_default ;
   private String[] P01132_A549OpeCliCodFormula ;
   private String[] P01132_A82OpeCliId ;
   private int[] P01132_A3CliCod ;
   private String[] P01132_A536OpeCliIdMay ;
   private String[] P01132_A534OpeCliDescrip ;
}

final  class grabaopecli2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01132( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15parmOpeCliId ,
                                          String A82OpeCliId ,
                                          String A549OpeCliCodFormula ,
                                          String AV14OpeCliCodFormula ,
                                          int AV10CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT OpeCliCodFormula, OpeCliId, CliCod, OpeCliIdMay, OpeCliDescrip FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV15parmOpeCliId)==0) )
      {
         addWhere(sWhereString, "(OpeCliId = ( ?))");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV15parmOpeCliId)==0) )
      {
         addWhere(sWhereString, "(OpeCliCodFormula = ( ?))");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      scmdbuf += " FOR UPDATE OF Variable" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01132(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01132", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01133", "SAVEPOINT gxupdate;UPDATE Variable SET OpeCliCodFormula=?, OpeCliDescrip=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01134", "SAVEPOINT gxupdate;UPDATE Variable SET OpeCliCodFormula=?, OpeCliDescrip=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01135", "SAVEPOINT gxupdate;INSERT INTO Variable(CliCod, OpeCliId, OpeCliCodFormula, OpeCliDescrip, OpeCliIdMay, OpeCliUsuCre, OpeCliFecCre, OpeCLiAliLey, OpeCliEsCant, OpeCliAliEs, VarBusGoogle, VarBusWeb, VarBaseURL, VarScrapTDoc, VarScrapTipo, VarFrecAct, VarScrapFin, VarRelRef, VarOld, VarActObl, VarHelp, VarDetail, VarRelSec, ValRelSecCli, OpeCliIdPadre) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 40);
               }
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(11, (String)parms[11], 400);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[13], 400);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(13, (String)parms[15], 1000);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[17], 20);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[19], 20);
               }
               stmt.setByte(16, ((Number) parms[20]).byteValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(17, (String)parms[22], 400);
               }
               stmt.setVarchar(18, (String)parms[23], 40, false);
               stmt.setNLongVarchar(19, (String)parms[24], false);
               stmt.setBoolean(20, ((Boolean) parms[25]).booleanValue());
               stmt.setNLongVarchar(21, (String)parms[26], false);
               stmt.setVarchar(22, (String)parms[27], 400, false);
               return;
      }
   }

}

