package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarregistromigracion extends GXProcedure
{
   public validarregistromigracion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarregistromigracion.class ), "" );
   }

   public validarregistromigracion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 int aP2 ,
                                                 boolean aP3 ,
                                                 boolean aP4 ,
                                                 short aP5 ,
                                                 GXSimpleCollection<String>[] aP6 )
   {
      validarregistromigracion.this.aP7 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        boolean aP4 ,
                        short aP5 ,
                        GXSimpleCollection<String>[] aP6 ,
                        GXSimpleCollection<String>[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             boolean aP4 ,
                             short aP5 ,
                             GXSimpleCollection<String>[] aP6 ,
                             GXSimpleCollection<String>[] aP7 )
   {
      validarregistromigracion.this.AV12CliCod = aP0;
      validarregistromigracion.this.AV13EmpCod = aP1;
      validarregistromigracion.this.AV25MigrLegNumero = aP2;
      validarregistromigracion.this.AV33informativo = aP3;
      validarregistromigracion.this.AV52erroresBlanquear = aP4;
      validarregistromigracion.this.AV58MigrArchSec = aP5;
      validarregistromigracion.this.aP6 = aP6;
      validarregistromigracion.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV56PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
      validarregistromigracion.this.GXt_int1 = GXv_int2[0] ;
      AV56PaiCod = GXt_int1 ;
      GXt_char3 = AV41ParmValue ;
      GXt_char4 = AV41ParmValue ;
      GXv_char5[0] = GXt_char4 ;
      new web.algoritmoequivimportleg_codigo(remoteHandle, context).execute( GXv_char5) ;
      validarregistromigracion.this.GXt_char4 = GXv_char5[0] ;
      GXv_char6[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char4, GXv_char6) ;
      validarregistromigracion.this.GXt_char3 = GXv_char6[0] ;
      AV41ParmValue = GXt_char3 ;
      AV40AlgortimoEquivalenciasImpLeg = AV41ParmValue ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "1 &MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV25MigrLegNumero, 8, 0))) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV25MigrLegNumero) ,
                                           Short.valueOf(AV58MigrArchSec) ,
                                           Integer.valueOf(A87MigrLegNumero) ,
                                           Short.valueOf(A2222MigrArchSec) ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV13EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P002C2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV25MigrLegNumero), Short.valueOf(AV58MigrArchSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P002C2_A3CliCod[0] ;
         A1EmpCod = P002C2_A1EmpCod[0] ;
         A87MigrLegNumero = P002C2_A87MigrLegNumero[0] ;
         A629MigrLegErrores = P002C2_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = P002C2_A633MigrLegWarnings[0] ;
         A2222MigrArchSec = P002C2_A2222MigrArchSec[0] ;
         n2222MigrArchSec = P002C2_n2222MigrArchSec[0] ;
         A592MigrLegApellido = P002C2_A592MigrLegApellido[0] ;
         A593MigrLegNombre = P002C2_A593MigrLegNombre[0] ;
         A595MigrLegSexo = P002C2_A595MigrLegSexo[0] ;
         A2240MigrLegPueAfip = P002C2_A2240MigrLegPueAfip[0] ;
         A2239MigrLegActLabClas = P002C2_A2239MigrLegActLabClas[0] ;
         A603MigrLegFecIngreso = P002C2_A603MigrLegFecIngreso[0] ;
         A596MigrLegEstadoCivil = P002C2_A596MigrLegEstadoCivil[0] ;
         A690MigrLegEstadoCivilDef = P002C2_A690MigrLegEstadoCivilDef[0] ;
         A597MigrLegCUIL = P002C2_A597MigrLegCUIL[0] ;
         A598MigrLegDiscapacidad = P002C2_A598MigrLegDiscapacidad[0] ;
         A599MigrLegDomici = P002C2_A599MigrLegDomici[0] ;
         A600MigrLegEmail = P002C2_A600MigrLegEmail[0] ;
         A601MigrLegCodPos = P002C2_A601MigrLegCodPos[0] ;
         A602MigrLegTelefono = P002C2_A602MigrLegTelefono[0] ;
         A604MigrLegCategoria = P002C2_A604MigrLegCategoria[0] ;
         A605MigrLegArea = P002C2_A605MigrLegArea[0] ;
         A2216MigrPuesto = P002C2_A2216MigrPuesto[0] ;
         A606MigrLegLugarDePago = P002C2_A606MigrLegLugarDePago[0] ;
         A2415MigrLegModTra = P002C2_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = P002C2_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = P002C2_A607MigrLegClase[0] ;
         A691MigrLegClaseDef = P002C2_A691MigrLegClaseDef[0] ;
         A609MigrLegFormaPago = P002C2_A609MigrLegFormaPago[0] ;
         A692MigrLegFormaPagoDef = P002C2_A692MigrLegFormaPagoDef[0] ;
         A610MigrLegBanco = P002C2_A610MigrLegBanco[0] ;
         A611MigrLegBanSuc = P002C2_A611MigrLegBanSuc[0] ;
         A612MigrLegBanTipCuen = P002C2_A612MigrLegBanTipCuen[0] ;
         A693MigrLegTipoCuentaDef = P002C2_A693MigrLegTipoCuentaDef[0] ;
         A613MigrLegSindicato = P002C2_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = P002C2_A614MigrLegObraSocial[0] ;
         A634MigrLegOSAfip = P002C2_A634MigrLegOSAfip[0] ;
         A615MigrLegPlanMedico = P002C2_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = P002C2_A616MigrLegActividad[0] ;
         A694MigrLegActividadDef = P002C2_A694MigrLegActividadDef[0] ;
         A617MigrLegModalidad = P002C2_A617MigrLegModalidad[0] ;
         A695MigrLegModalidadDef = P002C2_A695MigrLegModalidadDef[0] ;
         A619MigrLegCuentaBanc = P002C2_A619MigrLegCuentaBanc[0] ;
         A620MigrLegZona = P002C2_A620MigrLegZona[0] ;
         A696MigrLegZonaDef = P002C2_A696MigrLegZonaDef[0] ;
         A621MigrLegCBU = P002C2_A621MigrLegCBU[0] ;
         A623MigrLegSituacionRevista = P002C2_A623MigrLegSituacionRevista[0] ;
         A698MigrLegSituacionDef = P002C2_A698MigrLegSituacionDef[0] ;
         A624MigrLegCondicion = P002C2_A624MigrLegCondicion[0] ;
         A699MigrLegCondicionDef = P002C2_A699MigrLegCondicionDef[0] ;
         A625MigrLegSiniestrado = P002C2_A625MigrLegSiniestrado[0] ;
         A700MigrLegSiniestradoDef = P002C2_A700MigrLegSiniestradoDef[0] ;
         A626MigrLegId = P002C2_A626MigrLegId[0] ;
         A627MigrLegConvenio = P002C2_A627MigrLegConvenio[0] ;
         A628MigrLegObs = P002C2_A628MigrLegObs[0] ;
         A631MigrTieneConyuge = P002C2_A631MigrTieneConyuge[0] ;
         A594MigrLegFecNac = P002C2_A594MigrLegFecNac[0] ;
         A622MigrLegSCVO = P002C2_A622MigrLegSCVO[0] ;
         A608MigrLegBasico = P002C2_A608MigrLegBasico[0] ;
         A2189MigrSueldos = P002C2_A2189MigrSueldos[0] ;
         A2221MigrLegMarcaCCT = P002C2_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = P002C2_n2221MigrLegMarcaCCT[0] ;
         A2275MigrLegHorSem = P002C2_A2275MigrLegHorSem[0] ;
         AV14errores.clear();
         AV28warnings.clear();
         /* Using cursor P002C3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2084MigrLegFamErrores = P002C3_A2084MigrLegFamErrores[0] ;
            A2085MigrLegFamWarnings = P002C3_A2085MigrLegFamWarnings[0] ;
            A2086MigrLegFamDiscap = P002C3_A2086MigrLegFamDiscap[0] ;
            A2082MigrLegFamAdh = P002C3_A2082MigrLegFamAdh[0] ;
            A2080MigrLegFamNroDoc = P002C3_A2080MigrLegFamNroDoc[0] ;
            A2088MigrLegFamNomApe = P002C3_A2088MigrLegFamNomApe[0] ;
            A2079MigrLegFamParen = P002C3_A2079MigrLegFamParen[0] ;
            A2078MigrLegFamSec = P002C3_A2078MigrLegFamSec[0] ;
            AV42famErrores.clear();
            AV43FamWarnings.clear();
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "&informativo ", "")+GXutil.trim( GXutil.booltostr( AV33informativo))) ;
            if ( ! AV33informativo )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               A2084MigrLegFamErrores = "" ;
               A2085MigrLegFamWarnings = "" ;
               A2086MigrLegFamDiscap = GXutil.upper( A2086MigrLegFamDiscap) ;
               A2082MigrLegFamAdh = GXutil.upper( A2082MigrLegFamAdh) ;
               A2080MigrLegFamNroDoc = GXutil.upper( A2080MigrLegFamNroDoc) ;
               A2088MigrLegFamNomApe = GXutil.upper( A2088MigrLegFamNomApe) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "antes ", "")+A2079MigrLegFamParen) ;
               A2079MigrLegFamParen = GXutil.upper( A2079MigrLegFamParen) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "despues ", "")+A2079MigrLegFamParen) ;
            }
            GXv_char6[0] = AV45ParCod ;
            GXv_objcol_svchar7[0] = AV42famErrores ;
            GXv_objcol_svchar8[0] = AV43FamWarnings ;
            GXv_char5[0] = AV36Descrip ;
            GXv_boolean9[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean11[0] = false ;
            GXv_char12[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Parentesco", ""), A2079MigrLegFamParen, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char6, GXv_objcol_svchar7, GXv_objcol_svchar8, GXv_char5, GXv_boolean9, GXv_boolean10, GXv_boolean11, GXv_char12) ;
            validarregistromigracion.this.AV45ParCod = GXv_char6[0] ;
            AV42famErrores = GXv_objcol_svchar7[0] ;
            AV43FamWarnings = GXv_objcol_svchar8[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char5[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            if ( ! AV33informativo )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               if ( AV34existe )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  GXt_char4 = A2079MigrLegFamParen ;
                  GXv_char12[0] = GXt_char4 ;
                  new web.sacaracentos2(remoteHandle, context).execute( A2079MigrLegFamParen, GXv_char12) ;
                  validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                  A2079MigrLegFamParen = GXt_char4 ;
                  GXv_char12[0] = "" ;
                  GXv_char6[0] = AV46ParDescripSinAc ;
                  new web.getparentesco(remoteHandle, context).execute( AV12CliCod, AV45ParCod, GXv_char12, GXv_char6) ;
                  validarregistromigracion.this.AV46ParDescripSinAc = GXv_char6[0] ;
                  if ( ! (GXutil.strcmp("", AV46ParDescripSinAc)==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A2079MigrLegFamParen = GXutil.trim( AV46ParDescripSinAc) ;
                  }
               }
            }
            if ( ! (GXutil.strcmp("", A2082MigrLegFamAdh)==0) )
            {
               GXv_boolean11[0] = false ;
               GXv_objcol_svchar8[0] = AV42famErrores ;
               GXv_char12[0] = "" ;
               GXv_boolean10[0] = false ;
               new web.traducirsinoaboolean(remoteHandle, context).execute( A3CliCod, A2082MigrLegFamAdh, httpContext.getMessage( "Adherente", ""), GXv_boolean11, GXv_objcol_svchar8, GXv_char12, GXv_boolean10) ;
               AV42famErrores = GXv_objcol_svchar8[0] ;
            }
            else
            {
               AV42famErrores.add(httpContext.getMessage( "Debe ingresar si es adherente a la obra social.", ""), 0);
            }
            if ( ! (GXutil.strcmp("", A2086MigrLegFamDiscap)==0) )
            {
               GXv_boolean11[0] = false ;
               GXv_objcol_svchar8[0] = AV42famErrores ;
               GXv_char12[0] = "" ;
               GXv_boolean10[0] = false ;
               new web.traducirsinoaboolean(remoteHandle, context).execute( A3CliCod, A2086MigrLegFamDiscap, httpContext.getMessage( "Discapacitado", ""), GXv_boolean11, GXv_objcol_svchar8, GXv_char12, GXv_boolean10) ;
               AV42famErrores = GXv_objcol_svchar8[0] ;
            }
            else
            {
               AV42famErrores.add(httpContext.getMessage( "Debe ingresar si el familiar es discapacitado.", ""), 0);
            }
            if ( ! AV33informativo )
            {
               if ( AV42famErrores.size() > 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "fam 3", "")) ;
                  AV15i = (short)(1) ;
                  while ( AV15i <= AV42famErrores.size() )
                  {
                     A2084MigrLegFamErrores += GXutil.trim( (String)AV42famErrores.elementAt(-1+AV15i)) + httpContext.getMessage( " <BR>", "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "fam agrega e ", "")+GXutil.trim( (String)AV42famErrores.elementAt(-1+AV15i))) ;
                     AV14errores.add(GXutil.trim( (String)AV42famErrores.elementAt(-1+AV15i)), 0);
                     AV15i = (short)(AV15i+1) ;
                  }
               }
               else
               {
               }
               if ( AV43FamWarnings.size() > 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "fam w3", "")) ;
                  AV15i = (short)(1) ;
                  while ( AV15i <= AV43FamWarnings.size() )
                  {
                     A2085MigrLegFamWarnings += GXutil.trim( (String)AV43FamWarnings.elementAt(-1+AV15i)) + httpContext.getMessage( " <BR>", "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "fam agrega w ", "")+GXutil.trim( (String)AV43FamWarnings.elementAt(-1+AV15i))) ;
                     AV28warnings.add(GXutil.trim( (String)AV43FamWarnings.elementAt(-1+AV15i)), 0);
                     AV15i = (short)(AV15i+1) ;
                  }
               }
            }
            /* Using cursor P002C4 */
            pr_default.execute(2, new Object[] {A2084MigrLegFamErrores, A2085MigrLegFamWarnings, A2086MigrLegFamDiscap, A2082MigrLegFamAdh, A2080MigrLegFamNroDoc, A2088MigrLegFamNomApe, A2079MigrLegFamParen, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( ! AV33informativo )
         {
            if ( AV52erroresBlanquear )
            {
               A629MigrLegErrores = "" ;
               A633MigrLegWarnings = "" ;
            }
            A592MigrLegApellido = GXutil.upper( A592MigrLegApellido) ;
            A593MigrLegNombre = GXutil.upper( A593MigrLegNombre) ;
            A595MigrLegSexo = GXutil.upper( A595MigrLegSexo) ;
            A2240MigrLegPueAfip = GXutil.upper( A2240MigrLegPueAfip) ;
            A2239MigrLegActLabClas = GXutil.upper( A2239MigrLegActLabClas) ;
            if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A603MigrLegFecIngreso)) )
            {
               A603MigrLegFecIngreso = GXutil.serverDate( context, remoteHandle, pr_default) ;
            }
            if ( GXutil.len( A595MigrLegSexo) == 1 )
            {
               GXv_int13[0] = AV20LegSexo ;
               GXv_objcol_svchar8[0] = AV14errores ;
               GXv_char12[0] = "" ;
               GXv_boolean11[0] = AV49sexoHay ;
               new web.traducirsexo(remoteHandle, context).execute( AV12CliCod, A595MigrLegSexo, GXv_int13, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
               validarregistromigracion.this.AV20LegSexo = GXv_int13[0] ;
               AV14errores = GXv_objcol_svchar8[0] ;
               validarregistromigracion.this.AV49sexoHay = GXv_boolean11[0] ;
               if ( ( AV49sexoHay ) && ! (0==AV20LegSexo) )
               {
                  GXv_char12[0] = AV50SexoNombre ;
                  new web.getsexonombre(remoteHandle, context).execute( AV20LegSexo, GXv_char12) ;
                  validarregistromigracion.this.AV50SexoNombre = GXv_char12[0] ;
                  A595MigrLegSexo = GXutil.trim( AV50SexoNombre) ;
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "MigrLegEstadoCivil ", "")+A596MigrLegEstadoCivil) ;
            if ( ! (GXutil.strcmp("", A596MigrLegEstadoCivil)==0) )
            {
               A596MigrLegEstadoCivil = GXutil.upper( A596MigrLegEstadoCivil) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Estado Civil", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A690MigrLegEstadoCivilDef = (boolean)(((GXutil.strcmp(A596MigrLegEstadoCivil, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A596MigrLegEstadoCivil ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Estado Civil", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A596MigrLegEstadoCivil = GXt_char4 ;
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Estado Civil", ""), A596MigrLegEstadoCivil, GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               A690MigrLegEstadoCivilDef = true ;
            }
            A597MigrLegCUIL = GXutil.upper( A597MigrLegCUIL) ;
            A598MigrLegDiscapacidad = GXutil.upper( A598MigrLegDiscapacidad) ;
            A599MigrLegDomici = GXutil.upper( A599MigrLegDomici) ;
            A600MigrLegEmail = GXutil.upper( A600MigrLegEmail) ;
            A601MigrLegCodPos = GXutil.upper( A601MigrLegCodPos) ;
            A602MigrLegTelefono = GXutil.upper( A602MigrLegTelefono) ;
            A604MigrLegCategoria = GXutil.upper( A604MigrLegCategoria) ;
            if ( (GXutil.strcmp("", A605MigrLegArea)==0) && ! (GXutil.strcmp("", A2239MigrLegActLabClas)==0) )
            {
               GXv_char12[0] = AV57auxMigrLegArea ;
               new web.sacaracentos2(remoteHandle, context).execute( A2239MigrLegActLabClas, GXv_char12) ;
               validarregistromigracion.this.AV57auxMigrLegArea = GXv_char12[0] ;
               if ( CommonUtil.decimalVal( AV57auxMigrLegArea, ".").doubleValue() > 0 )
               {
                  GXv_char12[0] = AV55ActLabAreaGen ;
                  new web.getareagendeactlabclasporcod(remoteHandle, context).execute( AV56PaiCod, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV57auxMigrLegArea, "."))), GXv_char12) ;
                  validarregistromigracion.this.AV55ActLabAreaGen = GXv_char12[0] ;
               }
               if ( (GXutil.strcmp("", AV55ActLabAreaGen)==0) )
               {
                  GXv_char12[0] = AV55ActLabAreaGen ;
                  new web.getareagendeactlabclaspordesc(remoteHandle, context).execute( AV56PaiCod, GXutil.trim( GXutil.upper( AV57auxMigrLegArea)), GXv_char12) ;
                  validarregistromigracion.this.AV55ActLabAreaGen = GXv_char12[0] ;
               }
               if ( ! (GXutil.strcmp("", AV55ActLabAreaGen)==0) )
               {
                  A605MigrLegArea = GXutil.trim( GXutil.upper( AV55ActLabAreaGen)) ;
               }
            }
            if ( ! (GXutil.strcmp("", A605MigrLegArea)==0) && (GXutil.strcmp("", A2216MigrPuesto)==0) && ! (GXutil.strcmp("", A2240MigrLegPueAfip)==0) )
            {
               GXv_char12[0] = AV64auxMigrPuesto ;
               new web.sacaracentos2(remoteHandle, context).execute( A2240MigrLegPueAfip, GXv_char12) ;
               validarregistromigracion.this.AV64auxMigrPuesto = GXv_char12[0] ;
               GXv_char12[0] = AV65PueAfipGenDes ;
               new web.getpuestogendepuestoafipporcod(remoteHandle, context).execute( AV64auxMigrPuesto, GXv_char12) ;
               validarregistromigracion.this.AV65PueAfipGenDes = GXv_char12[0] ;
               if ( (GXutil.strcmp("", AV65PueAfipGenDes)==0) )
               {
                  GXv_char12[0] = AV65PueAfipGenDes ;
                  new web.getpuestogendepuestoafippordesc(remoteHandle, context).execute( GXutil.trim( GXutil.upper( AV64auxMigrPuesto)), GXv_char12) ;
                  validarregistromigracion.this.AV65PueAfipGenDes = GXv_char12[0] ;
               }
               if ( ! (GXutil.strcmp("", AV65PueAfipGenDes)==0) )
               {
                  A2216MigrPuesto = GXutil.trim( GXutil.upper( AV65PueAfipGenDes)) ;
               }
               else
               {
                  if ( ! (GXutil.strcmp("", A2240MigrLegPueAfip)==0) )
                  {
                     A2216MigrPuesto = GXutil.upper( GXutil.trim( A2240MigrLegPueAfip)) ;
                  }
               }
            }
            A606MigrLegLugarDePago = GXutil.upper( A606MigrLegLugarDePago) ;
            if ( ! (GXutil.strcmp("", A2415MigrLegModTra)==0) )
            {
               A2415MigrLegModTra = GXutil.upper( A2415MigrLegModTra) ;
            }
            else
            {
               GXt_char4 = A2415MigrLegModTra ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Relación laboral", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A2415MigrLegModTra = GXt_char4 ;
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Relación laboral", ""), A2415MigrLegModTra, GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            if ( ! (GXutil.strcmp("", A2427MigrLegTipoTarifa)==0) )
            {
               A2427MigrLegTipoTarifa = GXutil.upper( A2427MigrLegTipoTarifa) ;
            }
            else
            {
               GXt_char4 = A2427MigrLegTipoTarifa ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Tipo de tarifa", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A2427MigrLegTipoTarifa = GXt_char4 ;
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Tipo de tarifa", ""), A2427MigrLegTipoTarifa, GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            if ( ! (GXutil.strcmp("", A607MigrLegClase)==0) )
            {
               A607MigrLegClase = GXutil.upper( A607MigrLegClase) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Frecuencia de pago", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A691MigrLegClaseDef = (boolean)(((GXutil.strcmp(A607MigrLegClase, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A607MigrLegClase ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Frecuencia de pago", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A607MigrLegClase = GXt_char4 ;
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Frecuencia de pago", ""), A607MigrLegClase, GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               A691MigrLegClaseDef = true ;
            }
            if ( ! (GXutil.strcmp("", A609MigrLegFormaPago)==0) )
            {
               A609MigrLegFormaPago = GXutil.upper( A609MigrLegFormaPago) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Forma de Pago", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A692MigrLegFormaPagoDef = (boolean)(((GXutil.strcmp(A609MigrLegFormaPago, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A609MigrLegFormaPago ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Forma de Pago", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A609MigrLegFormaPago = GXt_char4 ;
               A692MigrLegFormaPagoDef = true ;
            }
            A610MigrLegBanco = GXutil.upper( A610MigrLegBanco) ;
            A611MigrLegBanSuc = GXutil.upper( A611MigrLegBanSuc) ;
            if ( ! (GXutil.strcmp("", A612MigrLegBanTipCuen)==0) )
            {
               A612MigrLegBanTipCuen = GXutil.upper( A612MigrLegBanTipCuen) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Tipo de Cuenta", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A693MigrLegTipoCuentaDef = (boolean)(((GXutil.strcmp(A612MigrLegBanTipCuen, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A612MigrLegBanTipCuen ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Tipo de Cuenta", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A612MigrLegBanTipCuen = GXt_char4 ;
               A693MigrLegTipoCuentaDef = true ;
            }
            A613MigrLegSindicato = GXutil.upper( A613MigrLegSindicato) ;
            A614MigrLegObraSocial = GXutil.upper( A614MigrLegObraSocial) ;
            A634MigrLegOSAfip = GXutil.upper( A634MigrLegOSAfip) ;
            A615MigrLegPlanMedico = GXutil.upper( A615MigrLegPlanMedico) ;
            if ( ! (GXutil.strcmp("", A616MigrLegActividad)==0) )
            {
               A616MigrLegActividad = GXutil.upper( A616MigrLegActividad) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Actividad", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A694MigrLegActividadDef = (boolean)(((GXutil.strcmp(A616MigrLegActividad, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A616MigrLegActividad ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Actividad", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A616MigrLegActividad = GXt_char4 ;
               A694MigrLegActividadDef = true ;
            }
            if ( ! (GXutil.strcmp("", A617MigrLegModalidad)==0) )
            {
               A617MigrLegModalidad = GXutil.upper( A617MigrLegModalidad) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Modalidad", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A695MigrLegModalidadDef = (boolean)(((GXutil.strcmp(A617MigrLegModalidad, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A617MigrLegModalidad ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Modalidad", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A617MigrLegModalidad = GXt_char4 ;
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Modalidad", ""), A617MigrLegModalidad, GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               A695MigrLegModalidadDef = true ;
            }
            A619MigrLegCuentaBanc = GXutil.upper( A619MigrLegCuentaBanc) ;
            if ( ! (GXutil.strcmp("", A620MigrLegZona)==0) )
            {
               A620MigrLegZona = GXutil.upper( A620MigrLegZona) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Zona", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A696MigrLegZonaDef = (boolean)(((GXutil.strcmp(A620MigrLegZona, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A620MigrLegZona ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Zona", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A620MigrLegZona = GXt_char4 ;
               A696MigrLegZonaDef = true ;
            }
            A621MigrLegCBU = GXutil.upper( A621MigrLegCBU) ;
            if ( ! (GXutil.strcmp("", A623MigrLegSituacionRevista)==0) )
            {
               A623MigrLegSituacionRevista = GXutil.upper( A623MigrLegSituacionRevista) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Situación", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A698MigrLegSituacionDef = (boolean)(((GXutil.strcmp(A623MigrLegSituacionRevista, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A623MigrLegSituacionRevista ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Situación", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A623MigrLegSituacionRevista = GXt_char4 ;
            }
            if ( ! (GXutil.strcmp("", A624MigrLegCondicion)==0) )
            {
               A624MigrLegCondicion = GXutil.upper( A624MigrLegCondicion) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Condición", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A699MigrLegCondicionDef = (boolean)(((GXutil.strcmp(A624MigrLegCondicion, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A624MigrLegCondicion ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Condición", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A624MigrLegCondicion = GXt_char4 ;
            }
            if ( ! (GXutil.strcmp("", A625MigrLegSiniestrado)==0) )
            {
               A625MigrLegSiniestrado = GXutil.upper( A625MigrLegSiniestrado) ;
               GXt_char4 = "" ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Siniestrado", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A700MigrLegSiniestradoDef = (boolean)(((GXutil.strcmp(A625MigrLegSiniestrado, GXt_char4)==0))) ;
            }
            else
            {
               GXt_char4 = A625MigrLegSiniestrado ;
               GXv_char12[0] = GXt_char4 ;
               new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, httpContext.getMessage( "Siniestrado", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               A625MigrLegSiniestrado = GXt_char4 ;
            }
            A626MigrLegId = GXutil.upper( A626MigrLegId) ;
            A627MigrLegConvenio = GXutil.upper( A627MigrLegConvenio) ;
            A628MigrLegObs = GXutil.upper( A628MigrLegObs) ;
            A631MigrTieneConyuge = GXutil.upper( A631MigrTieneConyuge) ;
            A597MigrLegCUIL = GXutil.strReplace( A597MigrLegCUIL, "-", "") ;
            A613MigrLegSindicato = GXutil.strReplace( A613MigrLegSindicato, ".", "") ;
            A614MigrLegObraSocial = GXutil.strReplace( A614MigrLegObraSocial, ".", "") ;
         }
         new web.getmigrmismapersona(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, A626MigrLegId, A597MigrLegCUIL, AV30existeMismoId, AV29existeMismoCUIL) ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A594MigrLegFecNac)) )
         {
            if ( GXutil.strSearch( A633MigrLegWarnings, new web.warningmigrfaltadato(remoteHandle, context).executeUdp( httpContext.getMessage( "Fecha de nacimiento", "")), 1) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Fecha de nacimiento", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         if ( (GXutil.strcmp("", A595MigrLegSexo)==0) )
         {
            if ( GXutil.strSearch( A633MigrLegWarnings, new web.warningmigrfaltadato(remoteHandle, context).executeUdp( httpContext.getMessage( "Género", "")), 1) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Género", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         if ( (GXutil.strcmp("", A614MigrLegObraSocial)==0) )
         {
            if ( GXutil.strSearch( A633MigrLegWarnings, new web.warningmigrfaltadato(remoteHandle, context).executeUdp( httpContext.getMessage( "Obra social", "")), 1) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV62MigrLegWarnings = A633MigrLegWarnings ;
               GXt_char4 = AV61advertencia ;
               GXv_char12[0] = GXt_char4 ;
               new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Obra social", ""), GXv_char12) ;
               validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
               AV61advertencia = GXt_char4 ;
               /* Execute user subroutine: 'AGREGAR WARNING' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "setea empty warningsy errores", "")) ;
         if ( ( AV30existeMismoId ) || ( AV29existeMismoCUIL ) )
         {
            if ( ( AV30existeMismoId ) && ( AV29existeMismoCUIL ) )
            {
               AV60MigrLegErrores = A629MigrLegErrores ;
               AV59error = httpContext.getMessage( "Registro duplicado en ID ", "") + GXutil.trim( A626MigrLegId) + httpContext.getMessage( " / CUIL ", "") + GXutil.trim( A597MigrLegCUIL) ;
               /* Execute user subroutine: 'AGREGAR ERROR' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               if ( AV30existeMismoId )
               {
                  AV60MigrLegErrores = A629MigrLegErrores ;
                  AV59error = httpContext.getMessage( "Registro duplicado en ID ", "") + GXutil.trim( A626MigrLegId) ;
                  /* Execute user subroutine: 'AGREGAR ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  AV60MigrLegErrores = A629MigrLegErrores ;
                  AV59error = httpContext.getMessage( "Registro duplicado en CUIL ", "") + GXutil.trim( A597MigrLegCUIL) ;
                  /* Execute user subroutine: 'AGREGAR ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
         }
         else
         {
            GXv_int14[0] = AV19LegNumero ;
            GXv_char12[0] = AV31LegNomApe ;
            new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int14, GXv_char12) ;
            validarregistromigracion.this.AV19LegNumero = GXv_int14[0] ;
            validarregistromigracion.this.AV31LegNomApe = GXv_char12[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV19LegNumero, 8, 0))) ;
            if ( ! (0==AV19LegNumero) )
            {
               AV60MigrLegErrores = A629MigrLegErrores ;
               AV59error = httpContext.getMessage( "El id ", "") + GXutil.trim( A626MigrLegId) + httpContext.getMessage( " ya existe en la empresa, legajo \"", "") + GXutil.trim( AV31LegNomApe) + "\"" ;
               /* Execute user subroutine: 'AGREGAR ERROR' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            GXv_int14[0] = AV19LegNumero ;
            GXv_char12[0] = AV32LegIdNomApe ;
            new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int14, GXv_char12) ;
            validarregistromigracion.this.AV19LegNumero = GXv_int14[0] ;
            validarregistromigracion.this.AV32LegIdNomApe = GXv_char12[0] ;
            if ( ! (0==AV19LegNumero) )
            {
               AV60MigrLegErrores = A629MigrLegErrores ;
               AV59error = httpContext.getMessage( "El CUIL ", "") + GXutil.trim( A597MigrLegCUIL) + httpContext.getMessage( " ya existe en la empresa, legajo \"", "") + GXutil.trim( AV32LegIdNomApe) + "\"" ;
               /* Execute user subroutine: 'AGREGAR ERROR' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            GXv_int13[0] = AV20LegSexo ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirsexo(remoteHandle, context).execute( A3CliCod, A595MigrLegSexo, GXv_int13, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
            validarregistromigracion.this.AV20LegSexo = GXv_int13[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int2[0] = AV9EstadoCivil ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirestadocivil(remoteHandle, context).execute( A3CliCod, A596MigrLegEstadoCivil, GXv_int2, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
            validarregistromigracion.this.AV9EstadoCivil = GXv_int2[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int2[0] = AV18LegDiscapacidad ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirsinoanum(remoteHandle, context).execute( A3CliCod, A598MigrLegDiscapacidad, httpContext.getMessage( "Discapacidad", ""), GXv_int2, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
            validarregistromigracion.this.AV18LegDiscapacidad = (byte)((byte)(GXv_int2[0])) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int14[0] = A3CliCod ;
            GXv_char12[0] = AV71modo_trabajo ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirmodotrabajo(remoteHandle, context).execute( GXv_int14, A2415MigrLegModTra, GXv_char12, GXv_objcol_svchar8, GXv_char6, GXv_boolean11) ;
            validarregistromigracion.this.A3CliCod = GXv_int14[0] ;
            validarregistromigracion.this.AV71modo_trabajo = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int14[0] = A3CliCod ;
            GXv_char12[0] = AV72tipo_tarifa ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirtipotarifa(remoteHandle, context).execute( GXv_int14, A2427MigrLegTipoTarifa, GXv_char12, GXv_objcol_svchar8, GXv_char6, GXv_boolean11) ;
            validarregistromigracion.this.A3CliCod = GXv_int14[0] ;
            validarregistromigracion.this.AV72tipo_tarifa = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int14[0] = A3CliCod ;
            GXv_int13[0] = AV8ClaseLeg ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirclaselegajo(remoteHandle, context).execute( GXv_int14, A607MigrLegClase, GXv_int13, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
            validarregistromigracion.this.A3CliCod = GXv_int14[0] ;
            validarregistromigracion.this.AV8ClaseLeg = GXv_int13[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_int13[0] = AV10FormaDePago ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirformapago(remoteHandle, context).execute( A3CliCod, A609MigrLegFormaPago, GXv_int13, GXv_objcol_svchar8, GXv_char12, GXv_boolean11) ;
            validarregistromigracion.this.AV10FormaDePago = GXv_int13[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_boolean11[0] = false ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char12[0] = "" ;
            GXv_boolean10[0] = false ;
            new web.traducirsinoaboolean(remoteHandle, context).execute( A3CliCod, A622MigrLegSCVO, httpContext.getMessage( "SCVO", ""), GXv_boolean11, GXv_objcol_svchar8, GXv_char12, GXv_boolean10) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_char12[0] = AV17LegBanTipCuen ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            new web.traducirtipocuentabanco(remoteHandle, context).execute( A3CliCod, A612MigrLegBanTipCuen, GXv_char12, GXv_objcol_svchar8, GXv_char6, GXv_boolean11) ;
            validarregistromigracion.this.AV17LegBanTipCuen = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            GXv_char12[0] = AV26SecCodigo ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = false ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Area", ""), A605MigrLegArea, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            validarregistromigracion.this.AV26SecCodigo = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  GXt_char4 = A605MigrLegArea ;
                  GXv_char12[0] = GXt_char4 ;
                  new web.sacaracentos2(remoteHandle, context).execute( A605MigrLegArea, GXv_char12) ;
                  validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                  A605MigrLegArea = GXt_char4 ;
               }
            }
            GXv_char12[0] = AV37SinCod ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = false ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Sindicato", ""), A613MigrLegSindicato, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            validarregistromigracion.this.AV37SinCod = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  GXt_char4 = A613MigrLegSindicato ;
                  GXv_char12[0] = GXt_char4 ;
                  new web.sacaracentos2(remoteHandle, context).execute( A613MigrLegSindicato, GXv_char12) ;
                  validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                  A613MigrLegSindicato = GXt_char4 ;
               }
            }
            GXv_char12[0] = AV38ConveCodigo ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Convenio", ""), A627MigrLegConvenio, false, AV37SinCod, AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            validarregistromigracion.this.AV38ConveCodigo = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A627MigrLegConvenio = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A627MigrLegConvenio ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A627MigrLegConvenio, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A627MigrLegConvenio = GXt_char4 ;
                  }
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "MigrSueldos ", "")+GXutil.trim( A2189MigrSueldos)+httpContext.getMessage( " MigrLegBasico ", "")+GXutil.trim( GXutil.str( A608MigrLegBasico, 14, 2))+httpContext.getMessage( " MigrLegConvenio \"", "")+A627MigrLegConvenio+"\"") ;
            if ( ! (GXutil.strcmp("", A2189MigrSueldos)==0) && ! (GXutil.strcmp("", A627MigrLegConvenio)==0) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( A627MigrLegConvenio)), GXutil.trim( GXutil.upper( new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)))) != 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               GXv_char12[0] = AV48auxDescrip ;
               new web.reemplazosningunos(remoteHandle, context).execute( AV12CliCod, A627MigrLegConvenio, GXv_char12) ;
               validarregistromigracion.this.AV48auxDescrip = GXv_char12[0] ;
               if ( ! (GXutil.strcmp("", AV48auxDescrip)==0) )
               {
                  AV60MigrLegErrores = A629MigrLegErrores ;
                  AV59error = httpContext.getMessage( "Si ingresa convenio no debe ingresar Sueldo fuera de convenio en legajo ", "") + GXutil.trim( AV32LegIdNomApe) ;
                  /* Execute user subroutine: 'AGREGAR ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "MigrLegMarcaCCT ", "")+A2221MigrLegMarcaCCT) ;
               if ( ! (GXutil.strcmp("", A2189MigrSueldos)==0) && ( (GXutil.strcmp("", A627MigrLegConvenio)==0) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( A627MigrLegConvenio)), GXutil.trim( GXutil.upper( new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)))) == 0 ) ) && ( GXutil.strcmp(A2221MigrLegMarcaCCT, "1") == 0 ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV60MigrLegErrores = A629MigrLegErrores ;
                  if ( (GXutil.strcmp("", A627MigrLegConvenio)==0) )
                  {
                     AV59error = httpContext.getMessage( "El legajo está con marca de convenio en LSD y no se cuenta con dato de convenio", "") ;
                  }
                  else
                  {
                     AV59error = httpContext.getMessage( "El legajo está con marca de convenio en LSD y está ingresado como \"Fuera de convenio\" por excel o por archivo de relaciones laborales de AFIP", "") ;
                  }
                  /* Execute user subroutine: 'AGREGAR ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            if ( (GXutil.strcmp("", A613MigrLegSindicato)==0) && ! (GXutil.strcmp("", AV38ConveCodigo)==0) )
            {
               GXt_int1 = AV56PaiCod ;
               GXv_int2[0] = GXt_int1 ;
               new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
               validarregistromigracion.this.GXt_int1 = GXv_int2[0] ;
               AV56PaiCod = GXt_int1 ;
               GXv_char12[0] = AV63ConveSinCod ;
               new web.getsindicatodeconvenio(remoteHandle, context).execute( AV56PaiCod, AV38ConveCodigo, GXv_char12) ;
               validarregistromigracion.this.AV63ConveSinCod = GXv_char12[0] ;
               if ( ! (GXutil.strcmp("", AV63ConveSinCod)==0) )
               {
                  A613MigrLegSindicato = GXutil.upper( AV63ConveSinCod) ;
               }
            }
            GXv_char12[0] = AV54auxZonCod ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Zona", ""), A620MigrLegZona, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            validarregistromigracion.this.AV54auxZonCod = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A620MigrLegZona = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A620MigrLegZona ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A620MigrLegZona = GXt_char4 ;
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "zona ", "")+AV54auxZonCod) ;
            GXv_char12[0] = AV53auxDependencia ;
            new web.migrarmardependenciacategoria(remoteHandle, context).execute( AV38ConveCodigo, AV54auxZonCod, GXv_char12) ;
            validarregistromigracion.this.AV53auxDependencia = GXv_char12[0] ;
            if ( ! (GXutil.strcmp("", AV53auxDependencia)==0) )
            {
               GXv_char12[0] = AV11CatCodigo ;
               GXv_objcol_svchar8[0] = AV14errores ;
               GXv_objcol_svchar7[0] = AV28warnings ;
               GXv_char6[0] = AV36Descrip ;
               GXv_boolean11[0] = false ;
               GXv_boolean10[0] = AV34existe ;
               GXv_boolean9[0] = AV35codigoEs ;
               GXv_char5[0] = "" ;
               new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Categoria", ""), A604MigrLegCategoria, false, AV53auxDependencia, AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
               validarregistromigracion.this.AV11CatCodigo = GXv_char12[0] ;
               AV14errores = GXv_objcol_svchar8[0] ;
               AV28warnings = GXv_objcol_svchar7[0] ;
               validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
               validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
               validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
               if ( ! AV33informativo )
               {
                  if ( AV34existe )
                  {
                  }
               }
            }
            AV53auxDependencia = AV26SecCodigo ;
            if ( ! (GXutil.strcmp("", AV53auxDependencia)==0) )
            {
               GXv_char12[0] = "" ;
               GXv_objcol_svchar8[0] = AV14errores ;
               GXv_objcol_svchar7[0] = AV28warnings ;
               GXv_char6[0] = AV36Descrip ;
               GXv_boolean11[0] = false ;
               GXv_boolean10[0] = AV34existe ;
               GXv_boolean9[0] = AV35codigoEs ;
               GXv_char5[0] = "" ;
               new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Puesto", ""), A2216MigrPuesto, false, AV53auxDependencia, AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
               AV14errores = GXv_objcol_svchar8[0] ;
               AV28warnings = GXv_objcol_svchar7[0] ;
               validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
               validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
               validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
               if ( ! AV33informativo )
               {
                  if ( AV34existe )
                  {
                     if ( AV35codigoEs )
                     {
                        A2216MigrPuesto = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                     }
                     else
                     {
                        GXt_char4 = A2216MigrPuesto ;
                        GXv_char12[0] = GXt_char4 ;
                        new web.sacaracentos2(remoteHandle, context).execute( A2216MigrPuesto, GXv_char12) ;
                        validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                        A2216MigrPuesto = GXt_char4 ;
                     }
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Banco", ""), A610MigrLegBanco, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A610MigrLegBanco = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A610MigrLegBanco ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A610MigrLegBanco, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A610MigrLegBanco = GXt_char4 ;
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = "" ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = false ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Obra Social", ""), A614MigrLegObraSocial, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  GXt_char4 = A614MigrLegObraSocial ;
                  GXv_char12[0] = GXt_char4 ;
                  new web.sacaracentos2(remoteHandle, context).execute( A614MigrLegObraSocial, GXv_char12) ;
                  validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                  A614MigrLegObraSocial = GXt_char4 ;
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Actividad", ""), A616MigrLegActividad, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A616MigrLegActividad = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A616MigrLegActividad ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A616MigrLegActividad = GXt_char4 ;
                  }
               }
            }
            GXv_char12[0] = AV66MprCod ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Modalidad", ""), A617MigrLegModalidad, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            validarregistromigracion.this.AV66MprCod = GXv_char12[0] ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A617MigrLegModalidad = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A617MigrLegModalidad ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A617MigrLegModalidad = GXt_char4 ;
                  }
               }
            }
            if ( ! (GXutil.strcmp("", AV66MprCod)==0) )
            {
               GXv_char12[0] = AV70auxMprCod ;
               new web.getcodigomigracionafip(remoteHandle, context).execute( AV66MprCod, GXv_char12) ;
               validarregistromigracion.this.AV70auxMprCod = GXv_char12[0] ;
               GXv_boolean11[0] = AV67MprEsParcial ;
               new web.getmodalidadparcial(remoteHandle, context).execute( AV70auxMprCod, GXv_boolean11) ;
               validarregistromigracion.this.AV67MprEsParcial = GXv_boolean11[0] ;
               if ( AV67MprEsParcial )
               {
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A2275MigrLegHorSem)==0) )
                  {
                     AV60MigrLegErrores = A629MigrLegErrores ;
                     AV59error = httpContext.getMessage( "La modalidad \"", "") + GXutil.trim( AV66MprCod) + httpContext.getMessage( "\" es parcial y no se estableció cantidad de horas normales semanales.", "") ;
                     /* Execute user subroutine: 'AGREGAR ERROR' */
                     S111 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  else
                  {
                     GXv_decimal15[0] = AV69auxLegHorasSem ;
                     new web.gethorassemananormal_diurno(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV56PaiCod, AV38ConveCodigo, GXv_decimal15) ;
                     validarregistromigracion.this.AV69auxLegHorasSem = GXv_decimal15[0] ;
                     if ( DecimalUtil.compareTo(A2275MigrLegHorSem, AV69auxLegHorasSem) == 0 )
                     {
                        AV60MigrLegErrores = A629MigrLegErrores ;
                        AV59error = httpContext.getMessage( "La modalidad \"", "") + GXutil.trim( AV66MprCod) + httpContext.getMessage( "\" es jornada parcial y se estableció cantidad de horas normales semanales iguales a la jornada completa ", "") + GXutil.trim( GXutil.str( AV69auxLegHorasSem, 4, 1)) ;
                        AV59error += httpContext.getMessage( " para convenios \"", "") + GXutil.trim( AV38ConveCodigo) + "\"" ;
                        /* Execute user subroutine: 'AGREGAR ERROR' */
                        S111 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
               }
               else
               {
                  if ( ! (GXutil.strcmp("", A627MigrLegConvenio)==0) )
                  {
                     GXv_decimal15[0] = AV69auxLegHorasSem ;
                     new web.gethorassemananormal_diurno(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV56PaiCod, AV38ConveCodigo, GXv_decimal15) ;
                     validarregistromigracion.this.AV69auxLegHorasSem = GXv_decimal15[0] ;
                     if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A2275MigrLegHorSem)==0) )
                     {
                        A2275MigrLegHorSem = AV69auxLegHorasSem ;
                     }
                     else
                     {
                        if ( DecimalUtil.compareTo(A2275MigrLegHorSem, AV69auxLegHorasSem) != 0 )
                        {
                           AV60MigrLegErrores = A629MigrLegErrores ;
                           AV59error = httpContext.getMessage( "La modalidad \"", "") + GXutil.trim( AV66MprCod) + httpContext.getMessage( "\" es jornada completa y se estableció cantidad de horas normales semanales em ", "") + GXutil.trim( GXutil.str( A2275MigrLegHorSem, 4, 1)) + httpContext.getMessage( ", que difieren a la jornada completa ", "") + GXutil.trim( GXutil.str( AV69auxLegHorasSem, 4, 1)) ;
                           AV59error += httpContext.getMessage( " para convenios \"", "") + GXutil.trim( AV38ConveCodigo) + "\"" ;
                           /* Execute user subroutine: 'AGREGAR ERROR' */
                           S111 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                     }
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Actividad laboral AFIP", ""), A2239MigrLegActLabClas, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A2239MigrLegActLabClas = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A2239MigrLegActLabClas ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A2239MigrLegActLabClas, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A2239MigrLegActLabClas = GXt_char4 ;
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Puesto AFIP", ""), A2240MigrLegPueAfip, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A2240MigrLegPueAfip = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A2240MigrLegPueAfip ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A2240MigrLegPueAfip, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A2240MigrLegPueAfip = GXt_char4 ;
                  }
               }
               else
               {
                  if ( ! (GXutil.strcmp("", A2216MigrPuesto)==0) )
                  {
                     A2240MigrLegPueAfip = "" ;
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Situacion", ""), A623MigrLegSituacionRevista, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "MigrLegNumero ", "")+GXutil.trim( GXutil.str( A87MigrLegNumero, 8, 0))+httpContext.getMessage( " informa ", "")+GXutil.trim( GXutil.booltostr( AV33informativo))+httpContext.getMessage( " situacion \"", "")+A623MigrLegSituacionRevista+httpContext.getMessage( "\" existe ", "")+GXutil.trim( GXutil.booltostr( AV34existe))+httpContext.getMessage( "codigoes ", "")+GXutil.trim( GXutil.booltostr( AV35codigoEs))+httpContext.getMessage( " descrip ", "")+AV36Descrip) ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A623MigrLegSituacionRevista = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "le asigna la descrip", "")) ;
                  }
                  else
                  {
                     GXt_char4 = A623MigrLegSituacionRevista ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A623MigrLegSituacionRevista = GXt_char4 ;
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Condicion", ""), A624MigrLegCondicion, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A624MigrLegCondicion = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A624MigrLegCondicion ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A624MigrLegCondicion = GXt_char4 ;
                  }
               }
            }
            GXv_char12[0] = "" ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_objcol_svchar7[0] = AV28warnings ;
            GXv_char6[0] = AV36Descrip ;
            GXv_boolean11[0] = false ;
            GXv_boolean10[0] = AV34existe ;
            GXv_boolean9[0] = AV35codigoEs ;
            GXv_char5[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, httpContext.getMessage( "Siniestrado", ""), A625MigrLegSiniestrado, false, "", AV40AlgortimoEquivalenciasImpLeg, A629MigrLegErrores, A633MigrLegWarnings, GXv_char12, GXv_objcol_svchar8, GXv_objcol_svchar7, GXv_char6, GXv_boolean11, GXv_boolean10, GXv_boolean9, GXv_char5) ;
            AV14errores = GXv_objcol_svchar8[0] ;
            AV28warnings = GXv_objcol_svchar7[0] ;
            validarregistromigracion.this.AV36Descrip = GXv_char6[0] ;
            validarregistromigracion.this.AV34existe = GXv_boolean10[0] ;
            validarregistromigracion.this.AV35codigoEs = GXv_boolean9[0] ;
            if ( ! AV33informativo )
            {
               if ( AV34existe )
               {
                  if ( AV35codigoEs )
                  {
                     A625MigrLegSiniestrado = GXutil.upper( GXutil.trim( AV36Descrip)) ;
                  }
                  else
                  {
                     GXt_char4 = A625MigrLegSiniestrado ;
                     GXv_char12[0] = GXt_char4 ;
                     new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char12) ;
                     validarregistromigracion.this.GXt_char4 = GXv_char12[0] ;
                     A625MigrLegSiniestrado = GXt_char4 ;
                  }
               }
            }
            if ( ! (GXutil.strcmp("", A624MigrLegCondicion)==0) )
            {
               AV27tieneCondi = (short)(1) ;
            }
            else
            {
               AV27tieneCondi = (short)(0) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "&FormaDePago ", "")+GXutil.str( AV10FormaDePago, 1, 0)) ;
            GXv_objcol_svchar8[0] = AV14errores ;
            GXv_int14[0] = 0 ;
            new web.legajoasignarbc(remoteHandle, context).execute( (short)(0), A3CliCod, A1EmpCod, AV47Periodo, "", A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, AV20LegSexo, AV9EstadoCivil, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), (byte)(0), A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, GXutil.substring( A604MigrLegCategoria, 1, 20), GXutil.substring( A605MigrLegArea, 1, 20), GXutil.substring( A606MigrLegLugarDePago, 1, 20), AV71modo_trabajo, AV8ClaseLeg, AV72tipo_tarifa, A608MigrLegBasico, AV10FormaDePago, GXutil.substring( A610MigrLegBanco, 1, 20), GXutil.trim( A611MigrLegBanSuc), "CA", GXutil.substring( A613MigrLegSindicato, 1, 20), GXutil.substring( A614MigrLegObraSocial, 1, 20), GXutil.substring( A615MigrLegPlanMedico, 1, 20), GXutil.substring( A616MigrLegActividad, 1, 8), GXutil.substring( A617MigrLegModalidad, 1, 20), A619MigrLegCuentaBanc, GXutil.substring( A620MigrLegZona, 1, 20), A621MigrLegCBU, true, GXutil.substring( A623MigrLegSituacionRevista, 1, 4), GXutil.substring( A627MigrLegConvenio, 1, 20), AV27tieneCondi, GXutil.substring( A625MigrLegSiniestrado, 1, 4), A626MigrLegId, A628MigrLegObs, A2216MigrPuesto, A629MigrLegErrores, 0, A2240MigrLegPueAfip, "", A2275MigrLegHorSem, GXv_objcol_svchar8, GXv_int14) ;
            AV14errores = GXv_objcol_svchar8[0] ;
         }
         if ( ! AV33informativo )
         {
            if ( AV14errores.size() > 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, "3") ;
               AV15i = (short)(1) ;
               while ( AV15i <= AV14errores.size() )
               {
                  A629MigrLegErrores += GXutil.trim( (String)AV14errores.elementAt(-1+AV15i)) + httpContext.getMessage( " <BR>", "") ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "agrega e ", "")+GXutil.trim( (String)AV14errores.elementAt(-1+AV15i))) ;
                  AV15i = (short)(AV15i+1) ;
               }
            }
            else
            {
            }
            if ( AV28warnings.size() > 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "w3", "")) ;
               AV15i = (short)(1) ;
               while ( AV15i <= AV28warnings.size() )
               {
                  A633MigrLegWarnings += GXutil.trim( (String)AV28warnings.elementAt(-1+AV15i)) + httpContext.getMessage( " <BR>", "") ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV75Pgmname, httpContext.getMessage( "agrega w ", "")+GXutil.trim( (String)AV28warnings.elementAt(-1+AV15i))) ;
                  AV15i = (short)(AV15i+1) ;
               }
            }
         }
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A633MigrLegWarnings)), httpContext.getMessage( "<BR> <BR>", "")) == 0 )
         {
            A633MigrLegWarnings = "" ;
         }
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A629MigrLegErrores)), httpContext.getMessage( "<BR> <BR>", "")) == 0 )
         {
            A629MigrLegErrores = "" ;
         }
         /* Using cursor P002C5 */
         pr_default.execute(3, new Object[] {A629MigrLegErrores, A633MigrLegWarnings, A592MigrLegApellido, A593MigrLegNombre, A595MigrLegSexo, A2240MigrLegPueAfip, A2239MigrLegActLabClas, A603MigrLegFecIngreso, A596MigrLegEstadoCivil, Boolean.valueOf(A690MigrLegEstadoCivilDef), A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A604MigrLegCategoria, A605MigrLegArea, A2216MigrPuesto, A606MigrLegLugarDePago, A2415MigrLegModTra, A2427MigrLegTipoTarifa, A607MigrLegClase, Boolean.valueOf(A691MigrLegClaseDef), A609MigrLegFormaPago, Boolean.valueOf(A692MigrLegFormaPagoDef), A610MigrLegBanco, A611MigrLegBanSuc, A612MigrLegBanTipCuen, Boolean.valueOf(A693MigrLegTipoCuentaDef), A613MigrLegSindicato, A614MigrLegObraSocial, A634MigrLegOSAfip, A615MigrLegPlanMedico, A616MigrLegActividad, Boolean.valueOf(A694MigrLegActividadDef), A617MigrLegModalidad, Boolean.valueOf(A695MigrLegModalidadDef), A619MigrLegCuentaBanc, A620MigrLegZona, Boolean.valueOf(A696MigrLegZonaDef), A621MigrLegCBU, A623MigrLegSituacionRevista, Boolean.valueOf(A698MigrLegSituacionDef), A624MigrLegCondicion, Boolean.valueOf(A699MigrLegCondicionDef), A625MigrLegSiniestrado, Boolean.valueOf(A700MigrLegSiniestradoDef), A626MigrLegId, A627MigrLegConvenio, A628MigrLegObs, A631MigrTieneConyuge, A2275MigrLegHorSem, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'AGREGAR ERROR' Routine */
      returnInSub = false ;
      if ( GXutil.strSearch( AV60MigrLegErrores, AV59error, 1) == 0 )
      {
         AV14errores.add(AV59error, 0);
      }
   }

   public void S121( )
   {
      /* 'AGREGAR WARNING' Routine */
      returnInSub = false ;
      if ( GXutil.strSearch( AV62MigrLegWarnings, AV61advertencia, 1) == 0 )
      {
         AV28warnings.add(AV61advertencia, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = validarregistromigracion.this.AV14errores;
      this.aP7[0] = validarregistromigracion.this.AV28warnings;
      Application.commitDataStores(context, remoteHandle, pr_default, "validarregistromigracion");
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
      AV28warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41ParmValue = "" ;
      GXt_char3 = "" ;
      AV40AlgortimoEquivalenciasImpLeg = "" ;
      AV75Pgmname = "" ;
      scmdbuf = "" ;
      P002C2_A3CliCod = new int[1] ;
      P002C2_A1EmpCod = new short[1] ;
      P002C2_A87MigrLegNumero = new int[1] ;
      P002C2_A629MigrLegErrores = new String[] {""} ;
      P002C2_A633MigrLegWarnings = new String[] {""} ;
      P002C2_A2222MigrArchSec = new short[1] ;
      P002C2_n2222MigrArchSec = new boolean[] {false} ;
      P002C2_A592MigrLegApellido = new String[] {""} ;
      P002C2_A593MigrLegNombre = new String[] {""} ;
      P002C2_A595MigrLegSexo = new String[] {""} ;
      P002C2_A2240MigrLegPueAfip = new String[] {""} ;
      P002C2_A2239MigrLegActLabClas = new String[] {""} ;
      P002C2_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P002C2_A596MigrLegEstadoCivil = new String[] {""} ;
      P002C2_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      P002C2_A597MigrLegCUIL = new String[] {""} ;
      P002C2_A598MigrLegDiscapacidad = new String[] {""} ;
      P002C2_A599MigrLegDomici = new String[] {""} ;
      P002C2_A600MigrLegEmail = new String[] {""} ;
      P002C2_A601MigrLegCodPos = new String[] {""} ;
      P002C2_A602MigrLegTelefono = new String[] {""} ;
      P002C2_A604MigrLegCategoria = new String[] {""} ;
      P002C2_A605MigrLegArea = new String[] {""} ;
      P002C2_A2216MigrPuesto = new String[] {""} ;
      P002C2_A606MigrLegLugarDePago = new String[] {""} ;
      P002C2_A2415MigrLegModTra = new String[] {""} ;
      P002C2_A2427MigrLegTipoTarifa = new String[] {""} ;
      P002C2_A607MigrLegClase = new String[] {""} ;
      P002C2_A691MigrLegClaseDef = new boolean[] {false} ;
      P002C2_A609MigrLegFormaPago = new String[] {""} ;
      P002C2_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      P002C2_A610MigrLegBanco = new String[] {""} ;
      P002C2_A611MigrLegBanSuc = new String[] {""} ;
      P002C2_A612MigrLegBanTipCuen = new String[] {""} ;
      P002C2_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      P002C2_A613MigrLegSindicato = new String[] {""} ;
      P002C2_A614MigrLegObraSocial = new String[] {""} ;
      P002C2_A634MigrLegOSAfip = new String[] {""} ;
      P002C2_A615MigrLegPlanMedico = new String[] {""} ;
      P002C2_A616MigrLegActividad = new String[] {""} ;
      P002C2_A694MigrLegActividadDef = new boolean[] {false} ;
      P002C2_A617MigrLegModalidad = new String[] {""} ;
      P002C2_A695MigrLegModalidadDef = new boolean[] {false} ;
      P002C2_A619MigrLegCuentaBanc = new String[] {""} ;
      P002C2_A620MigrLegZona = new String[] {""} ;
      P002C2_A696MigrLegZonaDef = new boolean[] {false} ;
      P002C2_A621MigrLegCBU = new String[] {""} ;
      P002C2_A623MigrLegSituacionRevista = new String[] {""} ;
      P002C2_A698MigrLegSituacionDef = new boolean[] {false} ;
      P002C2_A624MigrLegCondicion = new String[] {""} ;
      P002C2_A699MigrLegCondicionDef = new boolean[] {false} ;
      P002C2_A625MigrLegSiniestrado = new String[] {""} ;
      P002C2_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      P002C2_A626MigrLegId = new String[] {""} ;
      P002C2_A627MigrLegConvenio = new String[] {""} ;
      P002C2_A628MigrLegObs = new String[] {""} ;
      P002C2_A631MigrTieneConyuge = new String[] {""} ;
      P002C2_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P002C2_A622MigrLegSCVO = new String[] {""} ;
      P002C2_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002C2_A2189MigrSueldos = new String[] {""} ;
      P002C2_A2221MigrLegMarcaCCT = new String[] {""} ;
      P002C2_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      P002C2_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A595MigrLegSexo = "" ;
      A2240MigrLegPueAfip = "" ;
      A2239MigrLegActLabClas = "" ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      A596MigrLegEstadoCivil = "" ;
      A597MigrLegCUIL = "" ;
      A598MigrLegDiscapacidad = "" ;
      A599MigrLegDomici = "" ;
      A600MigrLegEmail = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A604MigrLegCategoria = "" ;
      A605MigrLegArea = "" ;
      A2216MigrPuesto = "" ;
      A606MigrLegLugarDePago = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      A607MigrLegClase = "" ;
      A609MigrLegFormaPago = "" ;
      A610MigrLegBanco = "" ;
      A611MigrLegBanSuc = "" ;
      A612MigrLegBanTipCuen = "" ;
      A613MigrLegSindicato = "" ;
      A614MigrLegObraSocial = "" ;
      A634MigrLegOSAfip = "" ;
      A615MigrLegPlanMedico = "" ;
      A616MigrLegActividad = "" ;
      A617MigrLegModalidad = "" ;
      A619MigrLegCuentaBanc = "" ;
      A620MigrLegZona = "" ;
      A621MigrLegCBU = "" ;
      A623MigrLegSituacionRevista = "" ;
      A624MigrLegCondicion = "" ;
      A625MigrLegSiniestrado = "" ;
      A626MigrLegId = "" ;
      A627MigrLegConvenio = "" ;
      A628MigrLegObs = "" ;
      A631MigrTieneConyuge = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A622MigrLegSCVO = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      A2189MigrSueldos = "" ;
      A2221MigrLegMarcaCCT = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      P002C3_A3CliCod = new int[1] ;
      P002C3_A1EmpCod = new short[1] ;
      P002C3_A87MigrLegNumero = new int[1] ;
      P002C3_A2084MigrLegFamErrores = new String[] {""} ;
      P002C3_A2085MigrLegFamWarnings = new String[] {""} ;
      P002C3_A2086MigrLegFamDiscap = new String[] {""} ;
      P002C3_A2082MigrLegFamAdh = new String[] {""} ;
      P002C3_A2080MigrLegFamNroDoc = new String[] {""} ;
      P002C3_A2088MigrLegFamNomApe = new String[] {""} ;
      P002C3_A2079MigrLegFamParen = new String[] {""} ;
      P002C3_A2078MigrLegFamSec = new short[1] ;
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2082MigrLegFamAdh = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2079MigrLegFamParen = "" ;
      AV42famErrores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43FamWarnings = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45ParCod = "" ;
      AV36Descrip = "" ;
      AV46ParDescripSinAc = "" ;
      AV50SexoNombre = "" ;
      AV62MigrLegWarnings = "" ;
      AV61advertencia = "" ;
      AV57auxMigrLegArea = "" ;
      AV55ActLabAreaGen = "" ;
      AV64auxMigrPuesto = "" ;
      AV65PueAfipGenDes = "" ;
      AV60MigrLegErrores = "" ;
      AV59error = "" ;
      AV31LegNomApe = "" ;
      AV32LegIdNomApe = "" ;
      AV71modo_trabajo = "" ;
      AV72tipo_tarifa = "" ;
      GXv_int13 = new byte[1] ;
      AV17LegBanTipCuen = "" ;
      AV26SecCodigo = "" ;
      AV37SinCod = "" ;
      AV38ConveCodigo = "" ;
      AV48auxDescrip = "" ;
      GXv_int2 = new short[1] ;
      AV63ConveSinCod = "" ;
      AV54auxZonCod = "" ;
      AV53auxDependencia = "" ;
      AV11CatCodigo = "" ;
      AV66MprCod = "" ;
      AV70auxMprCod = "" ;
      AV69auxLegHorasSem = DecimalUtil.ZERO ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_objcol_svchar7 = new GXSimpleCollection[1] ;
      GXv_char6 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char5 = new String[1] ;
      GXt_char4 = "" ;
      GXv_char12 = new String[1] ;
      AV47Periodo = GXutil.nullDate() ;
      GXv_objcol_svchar8 = new GXSimpleCollection[1] ;
      GXv_int14 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validarregistromigracion__default(),
         new Object[] {
             new Object[] {
            P002C2_A3CliCod, P002C2_A1EmpCod, P002C2_A87MigrLegNumero, P002C2_A629MigrLegErrores, P002C2_A633MigrLegWarnings, P002C2_A2222MigrArchSec, P002C2_n2222MigrArchSec, P002C2_A592MigrLegApellido, P002C2_A593MigrLegNombre, P002C2_A595MigrLegSexo,
            P002C2_A2240MigrLegPueAfip, P002C2_A2239MigrLegActLabClas, P002C2_A603MigrLegFecIngreso, P002C2_A596MigrLegEstadoCivil, P002C2_A690MigrLegEstadoCivilDef, P002C2_A597MigrLegCUIL, P002C2_A598MigrLegDiscapacidad, P002C2_A599MigrLegDomici, P002C2_A600MigrLegEmail, P002C2_A601MigrLegCodPos,
            P002C2_A602MigrLegTelefono, P002C2_A604MigrLegCategoria, P002C2_A605MigrLegArea, P002C2_A2216MigrPuesto, P002C2_A606MigrLegLugarDePago, P002C2_A2415MigrLegModTra, P002C2_A2427MigrLegTipoTarifa, P002C2_A607MigrLegClase, P002C2_A691MigrLegClaseDef, P002C2_A609MigrLegFormaPago,
            P002C2_A692MigrLegFormaPagoDef, P002C2_A610MigrLegBanco, P002C2_A611MigrLegBanSuc, P002C2_A612MigrLegBanTipCuen, P002C2_A693MigrLegTipoCuentaDef, P002C2_A613MigrLegSindicato, P002C2_A614MigrLegObraSocial, P002C2_A634MigrLegOSAfip, P002C2_A615MigrLegPlanMedico, P002C2_A616MigrLegActividad,
            P002C2_A694MigrLegActividadDef, P002C2_A617MigrLegModalidad, P002C2_A695MigrLegModalidadDef, P002C2_A619MigrLegCuentaBanc, P002C2_A620MigrLegZona, P002C2_A696MigrLegZonaDef, P002C2_A621MigrLegCBU, P002C2_A623MigrLegSituacionRevista, P002C2_A698MigrLegSituacionDef, P002C2_A624MigrLegCondicion,
            P002C2_A699MigrLegCondicionDef, P002C2_A625MigrLegSiniestrado, P002C2_A700MigrLegSiniestradoDef, P002C2_A626MigrLegId, P002C2_A627MigrLegConvenio, P002C2_A628MigrLegObs, P002C2_A631MigrTieneConyuge, P002C2_A594MigrLegFecNac, P002C2_A622MigrLegSCVO, P002C2_A608MigrLegBasico,
            P002C2_A2189MigrSueldos, P002C2_A2221MigrLegMarcaCCT, P002C2_n2221MigrLegMarcaCCT, P002C2_A2275MigrLegHorSem
            }
            , new Object[] {
            P002C3_A3CliCod, P002C3_A1EmpCod, P002C3_A87MigrLegNumero, P002C3_A2084MigrLegFamErrores, P002C3_A2085MigrLegFamWarnings, P002C3_A2086MigrLegFamDiscap, P002C3_A2082MigrLegFamAdh, P002C3_A2080MigrLegFamNroDoc, P002C3_A2088MigrLegFamNomApe, P002C3_A2079MigrLegFamParen,
            P002C3_A2078MigrLegFamSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV75Pgmname = "validarRegistroMigracion" ;
      /* GeneXus formulas. */
      AV75Pgmname = "validarRegistroMigracion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LegSexo ;
   private byte AV18LegDiscapacidad ;
   private byte AV8ClaseLeg ;
   private byte AV10FormaDePago ;
   private byte GXv_int13[] ;
   private short AV13EmpCod ;
   private short AV58MigrArchSec ;
   private short AV56PaiCod ;
   private short A2222MigrArchSec ;
   private short A1EmpCod ;
   private short A2078MigrLegFamSec ;
   private short AV15i ;
   private short AV9EstadoCivil ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV27tieneCondi ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV25MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private int AV19LegNumero ;
   private int GXv_int14[] ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
   private java.math.BigDecimal AV69auxLegHorasSem ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String GXt_char3 ;
   private String AV40AlgortimoEquivalenciasImpLeg ;
   private String AV75Pgmname ;
   private String scmdbuf ;
   private String A595MigrLegSexo ;
   private String A597MigrLegCUIL ;
   private String A598MigrLegDiscapacidad ;
   private String A634MigrLegOSAfip ;
   private String A626MigrLegId ;
   private String A631MigrTieneConyuge ;
   private String A622MigrLegSCVO ;
   private String A2221MigrLegMarcaCCT ;
   private String A2086MigrLegFamDiscap ;
   private String A2082MigrLegFamAdh ;
   private String AV45ParCod ;
   private String AV71modo_trabajo ;
   private String AV72tipo_tarifa ;
   private String AV17LegBanTipCuen ;
   private String AV26SecCodigo ;
   private String AV37SinCod ;
   private String AV38ConveCodigo ;
   private String AV63ConveSinCod ;
   private String AV54auxZonCod ;
   private String AV11CatCodigo ;
   private String AV66MprCod ;
   private String AV70auxMprCod ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXt_char4 ;
   private String GXv_char12[] ;
   private java.util.Date A603MigrLegFecIngreso ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date AV47Periodo ;
   private boolean AV33informativo ;
   private boolean AV52erroresBlanquear ;
   private boolean n2222MigrArchSec ;
   private boolean A690MigrLegEstadoCivilDef ;
   private boolean A691MigrLegClaseDef ;
   private boolean A692MigrLegFormaPagoDef ;
   private boolean A693MigrLegTipoCuentaDef ;
   private boolean A694MigrLegActividadDef ;
   private boolean A695MigrLegModalidadDef ;
   private boolean A696MigrLegZonaDef ;
   private boolean A698MigrLegSituacionDef ;
   private boolean A699MigrLegCondicionDef ;
   private boolean A700MigrLegSiniestradoDef ;
   private boolean n2221MigrLegMarcaCCT ;
   private boolean Cond_result ;
   private boolean AV34existe ;
   private boolean AV49sexoHay ;
   private boolean returnInSub ;
   private boolean AV30existeMismoId ;
   private boolean AV29existeMismoCUIL ;
   private boolean AV35codigoEs ;
   private boolean AV67MprEsParcial ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean9[] ;
   private String AV41ParmValue ;
   private String A629MigrLegErrores ;
   private String A633MigrLegWarnings ;
   private String A628MigrLegObs ;
   private String A2189MigrSueldos ;
   private String A2084MigrLegFamErrores ;
   private String A2085MigrLegFamWarnings ;
   private String AV62MigrLegWarnings ;
   private String AV60MigrLegErrores ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A2240MigrLegPueAfip ;
   private String A2239MigrLegActLabClas ;
   private String A596MigrLegEstadoCivil ;
   private String A599MigrLegDomici ;
   private String A600MigrLegEmail ;
   private String A601MigrLegCodPos ;
   private String A602MigrLegTelefono ;
   private String A604MigrLegCategoria ;
   private String A605MigrLegArea ;
   private String A2216MigrPuesto ;
   private String A606MigrLegLugarDePago ;
   private String A2415MigrLegModTra ;
   private String A2427MigrLegTipoTarifa ;
   private String A607MigrLegClase ;
   private String A609MigrLegFormaPago ;
   private String A610MigrLegBanco ;
   private String A611MigrLegBanSuc ;
   private String A612MigrLegBanTipCuen ;
   private String A613MigrLegSindicato ;
   private String A614MigrLegObraSocial ;
   private String A615MigrLegPlanMedico ;
   private String A616MigrLegActividad ;
   private String A617MigrLegModalidad ;
   private String A619MigrLegCuentaBanc ;
   private String A620MigrLegZona ;
   private String A621MigrLegCBU ;
   private String A623MigrLegSituacionRevista ;
   private String A624MigrLegCondicion ;
   private String A625MigrLegSiniestrado ;
   private String A627MigrLegConvenio ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String A2079MigrLegFamParen ;
   private String AV36Descrip ;
   private String AV46ParDescripSinAc ;
   private String AV50SexoNombre ;
   private String AV61advertencia ;
   private String AV57auxMigrLegArea ;
   private String AV55ActLabAreaGen ;
   private String AV64auxMigrPuesto ;
   private String AV65PueAfipGenDes ;
   private String AV59error ;
   private String AV31LegNomApe ;
   private String AV32LegIdNomApe ;
   private String AV48auxDescrip ;
   private String AV53auxDependencia ;
   private GXSimpleCollection<String>[] aP7 ;
   private GXSimpleCollection<String>[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P002C2_A3CliCod ;
   private short[] P002C2_A1EmpCod ;
   private int[] P002C2_A87MigrLegNumero ;
   private String[] P002C2_A629MigrLegErrores ;
   private String[] P002C2_A633MigrLegWarnings ;
   private short[] P002C2_A2222MigrArchSec ;
   private boolean[] P002C2_n2222MigrArchSec ;
   private String[] P002C2_A592MigrLegApellido ;
   private String[] P002C2_A593MigrLegNombre ;
   private String[] P002C2_A595MigrLegSexo ;
   private String[] P002C2_A2240MigrLegPueAfip ;
   private String[] P002C2_A2239MigrLegActLabClas ;
   private java.util.Date[] P002C2_A603MigrLegFecIngreso ;
   private String[] P002C2_A596MigrLegEstadoCivil ;
   private boolean[] P002C2_A690MigrLegEstadoCivilDef ;
   private String[] P002C2_A597MigrLegCUIL ;
   private String[] P002C2_A598MigrLegDiscapacidad ;
   private String[] P002C2_A599MigrLegDomici ;
   private String[] P002C2_A600MigrLegEmail ;
   private String[] P002C2_A601MigrLegCodPos ;
   private String[] P002C2_A602MigrLegTelefono ;
   private String[] P002C2_A604MigrLegCategoria ;
   private String[] P002C2_A605MigrLegArea ;
   private String[] P002C2_A2216MigrPuesto ;
   private String[] P002C2_A606MigrLegLugarDePago ;
   private String[] P002C2_A2415MigrLegModTra ;
   private String[] P002C2_A2427MigrLegTipoTarifa ;
   private String[] P002C2_A607MigrLegClase ;
   private boolean[] P002C2_A691MigrLegClaseDef ;
   private String[] P002C2_A609MigrLegFormaPago ;
   private boolean[] P002C2_A692MigrLegFormaPagoDef ;
   private String[] P002C2_A610MigrLegBanco ;
   private String[] P002C2_A611MigrLegBanSuc ;
   private String[] P002C2_A612MigrLegBanTipCuen ;
   private boolean[] P002C2_A693MigrLegTipoCuentaDef ;
   private String[] P002C2_A613MigrLegSindicato ;
   private String[] P002C2_A614MigrLegObraSocial ;
   private String[] P002C2_A634MigrLegOSAfip ;
   private String[] P002C2_A615MigrLegPlanMedico ;
   private String[] P002C2_A616MigrLegActividad ;
   private boolean[] P002C2_A694MigrLegActividadDef ;
   private String[] P002C2_A617MigrLegModalidad ;
   private boolean[] P002C2_A695MigrLegModalidadDef ;
   private String[] P002C2_A619MigrLegCuentaBanc ;
   private String[] P002C2_A620MigrLegZona ;
   private boolean[] P002C2_A696MigrLegZonaDef ;
   private String[] P002C2_A621MigrLegCBU ;
   private String[] P002C2_A623MigrLegSituacionRevista ;
   private boolean[] P002C2_A698MigrLegSituacionDef ;
   private String[] P002C2_A624MigrLegCondicion ;
   private boolean[] P002C2_A699MigrLegCondicionDef ;
   private String[] P002C2_A625MigrLegSiniestrado ;
   private boolean[] P002C2_A700MigrLegSiniestradoDef ;
   private String[] P002C2_A626MigrLegId ;
   private String[] P002C2_A627MigrLegConvenio ;
   private String[] P002C2_A628MigrLegObs ;
   private String[] P002C2_A631MigrTieneConyuge ;
   private java.util.Date[] P002C2_A594MigrLegFecNac ;
   private String[] P002C2_A622MigrLegSCVO ;
   private java.math.BigDecimal[] P002C2_A608MigrLegBasico ;
   private String[] P002C2_A2189MigrSueldos ;
   private String[] P002C2_A2221MigrLegMarcaCCT ;
   private boolean[] P002C2_n2221MigrLegMarcaCCT ;
   private java.math.BigDecimal[] P002C2_A2275MigrLegHorSem ;
   private int[] P002C3_A3CliCod ;
   private short[] P002C3_A1EmpCod ;
   private int[] P002C3_A87MigrLegNumero ;
   private String[] P002C3_A2084MigrLegFamErrores ;
   private String[] P002C3_A2085MigrLegFamWarnings ;
   private String[] P002C3_A2086MigrLegFamDiscap ;
   private String[] P002C3_A2082MigrLegFamAdh ;
   private String[] P002C3_A2080MigrLegFamNroDoc ;
   private String[] P002C3_A2088MigrLegFamNomApe ;
   private String[] P002C3_A2079MigrLegFamParen ;
   private short[] P002C3_A2078MigrLegFamSec ;
   private GXSimpleCollection<String> AV14errores ;
   private GXSimpleCollection<String> AV28warnings ;
   private GXSimpleCollection<String> AV42famErrores ;
   private GXSimpleCollection<String> AV43FamWarnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar7[] ;
   private GXSimpleCollection<String> GXv_objcol_svchar8[] ;
}

final  class validarregistromigracion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV25MigrLegNumero ,
                                          short AV58MigrArchSec ,
                                          int A87MigrLegNumero ,
                                          short A2222MigrArchSec ,
                                          int AV12CliCod ,
                                          short AV13EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[4];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegErrores, MigrLegWarnings, MigrArchSec, MigrLegApellido, MigrLegNombre, MigrLegSexo, MigrLegPueAfip, MigrLegActLabClas," ;
      scmdbuf += " MigrLegFecIngreso, MigrLegEstadoCivil, MigrLegEstadoCivilDef, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegCategoria," ;
      scmdbuf += " MigrLegArea, MigrPuesto, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegClaseDef, MigrLegFormaPago, MigrLegFormaPagoDef, MigrLegBanco," ;
      scmdbuf += " MigrLegBanSuc, MigrLegBanTipCuen, MigrLegTipoCuentaDef, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegActividadDef," ;
      scmdbuf += " MigrLegModalidad, MigrLegModalidadDef, MigrLegCuentaBanc, MigrLegZona, MigrLegZonaDef, MigrLegCBU, MigrLegSituacionRevista, MigrLegSituacionDef, MigrLegCondicion," ;
      scmdbuf += " MigrLegCondicionDef, MigrLegSiniestrado, MigrLegSiniestradoDef, MigrLegId, MigrLegConvenio, MigrLegObs, MigrTieneConyuge, MigrLegFecNac, MigrLegSCVO, MigrLegBasico," ;
      scmdbuf += " MigrSueldos, MigrLegMarcaCCT, MigrLegHorSem FROM importacion_legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV25MigrLegNumero) )
      {
         addWhere(sWhereString, "(MigrLegNumero = ?)");
      }
      else
      {
         GXv_int16[2] = (byte)(1) ;
      }
      if ( ! (0==AV58MigrArchSec) )
      {
         addWhere(sWhereString, "(MigrArchSec = ?)");
      }
      else
      {
         GXv_int16[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF importacion_legajo" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_P002C2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002C2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002C3", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamDiscap, MigrLegFamAdh, MigrLegFamNroDoc, MigrLegFamNomApe, MigrLegFamParen, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero  FOR UPDATE OF importacion_legajoFamilia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P002C4", "SAVEPOINT gxupdate;UPDATE importacion_legajoFamilia SET MigrLegFamErrores=?, MigrLegFamWarnings=?, MigrLegFamDiscap=?, MigrLegFamAdh=?, MigrLegFamNroDoc=?, MigrLegFamNomApe=?, MigrLegFamParen=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P002C5", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegErrores=?, MigrLegWarnings=?, MigrLegApellido=?, MigrLegNombre=?, MigrLegSexo=?, MigrLegPueAfip=?, MigrLegActLabClas=?, MigrLegFecIngreso=?, MigrLegEstadoCivil=?, MigrLegEstadoCivilDef=?, MigrLegCUIL=?, MigrLegDiscapacidad=?, MigrLegDomici=?, MigrLegEmail=?, MigrLegCodPos=?, MigrLegTelefono=?, MigrLegCategoria=?, MigrLegArea=?, MigrPuesto=?, MigrLegLugarDePago=?, MigrLegModTra=?, MigrLegTipoTarifa=?, MigrLegClase=?, MigrLegClaseDef=?, MigrLegFormaPago=?, MigrLegFormaPagoDef=?, MigrLegBanco=?, MigrLegBanSuc=?, MigrLegBanTipCuen=?, MigrLegTipoCuentaDef=?, MigrLegSindicato=?, MigrLegObraSocial=?, MigrLegOSAfip=?, MigrLegPlanMedico=?, MigrLegActividad=?, MigrLegActividadDef=?, MigrLegModalidad=?, MigrLegModalidadDef=?, MigrLegCuentaBanc=?, MigrLegZona=?, MigrLegZonaDef=?, MigrLegCBU=?, MigrLegSituacionRevista=?, MigrLegSituacionDef=?, MigrLegCondicion=?, MigrLegCondicionDef=?, MigrLegSiniestrado=?, MigrLegSiniestradoDef=?, MigrLegId=?, MigrLegConvenio=?, MigrLegObs=?, MigrTieneConyuge=?, MigrLegHorSem=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(12);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 13);
               ((String[]) buf[16])[0] = rslt.getString(16, 2);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((String[]) buf[18])[0] = rslt.getVarchar(18);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((String[]) buf[21])[0] = rslt.getVarchar(21);
               ((String[]) buf[22])[0] = rslt.getVarchar(22);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((String[]) buf[25])[0] = rslt.getVarchar(25);
               ((String[]) buf[26])[0] = rslt.getVarchar(26);
               ((String[]) buf[27])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(28);
               ((String[]) buf[29])[0] = rslt.getVarchar(29);
               ((boolean[]) buf[30])[0] = rslt.getBoolean(30);
               ((String[]) buf[31])[0] = rslt.getVarchar(31);
               ((String[]) buf[32])[0] = rslt.getVarchar(32);
               ((String[]) buf[33])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(34);
               ((String[]) buf[35])[0] = rslt.getVarchar(35);
               ((String[]) buf[36])[0] = rslt.getVarchar(36);
               ((String[]) buf[37])[0] = rslt.getString(37, 20);
               ((String[]) buf[38])[0] = rslt.getVarchar(38);
               ((String[]) buf[39])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[40])[0] = rslt.getBoolean(40);
               ((String[]) buf[41])[0] = rslt.getVarchar(41);
               ((boolean[]) buf[42])[0] = rslt.getBoolean(42);
               ((String[]) buf[43])[0] = rslt.getVarchar(43);
               ((String[]) buf[44])[0] = rslt.getVarchar(44);
               ((boolean[]) buf[45])[0] = rslt.getBoolean(45);
               ((String[]) buf[46])[0] = rslt.getVarchar(46);
               ((String[]) buf[47])[0] = rslt.getVarchar(47);
               ((boolean[]) buf[48])[0] = rslt.getBoolean(48);
               ((String[]) buf[49])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(50);
               ((String[]) buf[51])[0] = rslt.getVarchar(51);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(52);
               ((String[]) buf[53])[0] = rslt.getString(53, 20);
               ((String[]) buf[54])[0] = rslt.getVarchar(54);
               ((String[]) buf[55])[0] = rslt.getLongVarchar(55);
               ((String[]) buf[56])[0] = rslt.getString(56, 20);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(57);
               ((String[]) buf[58])[0] = rslt.getString(58, 2);
               ((java.math.BigDecimal[]) buf[59])[0] = rslt.getBigDecimal(59,2);
               ((String[]) buf[60])[0] = rslt.getLongVarchar(60);
               ((String[]) buf[61])[0] = rslt.getString(61, 1);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[63])[0] = rslt.getBigDecimal(62,1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               return;
            case 3 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 255, false);
               stmt.setVarchar(7, (String)parms[6], 60, false);
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setString(11, (String)parms[10], 13);
               stmt.setString(12, (String)parms[11], 2);
               stmt.setVarchar(13, (String)parms[12], 4000, false);
               stmt.setVarchar(14, (String)parms[13], 100, false);
               stmt.setVarchar(15, (String)parms[14], 400, false);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setVarchar(20, (String)parms[19], 20, false);
               stmt.setVarchar(21, (String)parms[20], 400, false);
               stmt.setVarchar(22, (String)parms[21], 400, false);
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setBoolean(24, ((Boolean) parms[23]).booleanValue());
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setBoolean(26, ((Boolean) parms[25]).booleanValue());
               stmt.setVarchar(27, (String)parms[26], 400, false);
               stmt.setVarchar(28, (String)parms[27], 400, false);
               stmt.setVarchar(29, (String)parms[28], 20, false);
               stmt.setBoolean(30, ((Boolean) parms[29]).booleanValue());
               stmt.setVarchar(31, (String)parms[30], 400, false);
               stmt.setVarchar(32, (String)parms[31], 400, false);
               stmt.setString(33, (String)parms[32], 20);
               stmt.setVarchar(34, (String)parms[33], 400, false);
               stmt.setVarchar(35, (String)parms[34], 150, false);
               stmt.setBoolean(36, ((Boolean) parms[35]).booleanValue());
               stmt.setVarchar(37, (String)parms[36], 400, false);
               stmt.setBoolean(38, ((Boolean) parms[37]).booleanValue());
               stmt.setVarchar(39, (String)parms[38], 20, false);
               stmt.setVarchar(40, (String)parms[39], 400, false);
               stmt.setBoolean(41, ((Boolean) parms[40]).booleanValue());
               stmt.setVarchar(42, (String)parms[41], 22, false);
               stmt.setVarchar(43, (String)parms[42], 40, false);
               stmt.setBoolean(44, ((Boolean) parms[43]).booleanValue());
               stmt.setVarchar(45, (String)parms[44], 40, false);
               stmt.setBoolean(46, ((Boolean) parms[45]).booleanValue());
               stmt.setVarchar(47, (String)parms[46], 400, false);
               stmt.setBoolean(48, ((Boolean) parms[47]).booleanValue());
               stmt.setString(49, (String)parms[48], 20);
               stmt.setVarchar(50, (String)parms[49], 400, false);
               stmt.setNLongVarchar(51, (String)parms[50], false);
               stmt.setString(52, (String)parms[51], 20);
               stmt.setBigDecimal(53, (java.math.BigDecimal)parms[52], 1);
               stmt.setInt(54, ((Number) parms[53]).intValue());
               stmt.setShort(55, ((Number) parms[54]).shortValue());
               stmt.setInt(56, ((Number) parms[55]).intValue());
               return;
      }
   }

}

