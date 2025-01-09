package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aimportarlegajosseleccionados extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      aimportarlegajosseleccionados pgm = new aimportarlegajosseleccionados (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public aimportarlegajosseleccionados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aimportarlegajosseleccionados.class ), "" );
   }

   public aimportarlegajosseleccionados( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> executeUdp( )
   {
      aimportarlegajosseleccionados.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 )
   {
      aimportarlegajosseleccionados.this.AV18importacion_legajoWWSDT = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV49ParmValue ;
      GXt_char2 = AV49ParmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.algoritmoequivimportleg_codigo(remoteHandle, context).execute( GXv_char3) ;
      aimportarlegajosseleccionados.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char2, GXv_char4) ;
      aimportarlegajosseleccionados.this.GXt_char1 = GXv_char4[0] ;
      AV49ParmValue = GXt_char1 ;
      AV48algoritmoEquivalenciasUsar = AV49ParmValue ;
      if ( AV18importacion_legajoWWSDT.size() > 0 )
      {
         AV12CliCod = ((web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)AV18importacion_legajoWWSDT.elementAt(-1+1)).getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod() ;
         AV39EmpCod = ((web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)AV18importacion_legajoWWSDT.elementAt(-1+1)).getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod() ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "!!&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV39EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "&importacion_legajoWWSDT.COUT ", "")+GXutil.trim( GXutil.str( AV18importacion_legajoWWSDT.size(), 9, 0))) ;
      AV76GXV1 = 1 ;
      while ( AV76GXV1 <= AV18importacion_legajoWWSDT.size() )
      {
         AV19itemImportacion = (web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)((web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)AV18importacion_legajoWWSDT.elementAt(-1+AV76GXV1));
         AV15errores.clear();
         AV43warnings.clear();
         AV50sdt_import_LegFam.clear();
         AV77GXLvl17 = (byte)(0) ;
         /* Using cursor P000P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV39EmpCod), Integer.valueOf(AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero())});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A87MigrLegNumero = P000P2_A87MigrLegNumero[0] ;
            A1EmpCod = P000P2_A1EmpCod[0] ;
            A3CliCod = P000P2_A3CliCod[0] ;
            A633MigrLegWarnings = P000P2_A633MigrLegWarnings[0] ;
            A2079MigrLegFamParen = P000P2_A2079MigrLegFamParen[0] ;
            A2082MigrLegFamAdh = P000P2_A2082MigrLegFamAdh[0] ;
            A2086MigrLegFamDiscap = P000P2_A2086MigrLegFamDiscap[0] ;
            A2080MigrLegFamNroDoc = P000P2_A2080MigrLegFamNroDoc[0] ;
            A2081MigrLegFamDedGan = P000P2_A2081MigrLegFamDedGan[0] ;
            A2088MigrLegFamNomApe = P000P2_A2088MigrLegFamNomApe[0] ;
            A2089MigrLegFamFecNac = P000P2_A2089MigrLegFamFecNac[0] ;
            A2078MigrLegFamSec = P000P2_A2078MigrLegFamSec[0] ;
            A633MigrLegWarnings = P000P2_A633MigrLegWarnings[0] ;
            AV77GXLvl17 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "!WARNING AL COMIENZO ", "")+GXutil.trim( A633MigrLegWarnings)+httpContext.getMessage( " MigrLegNumero ", "")+GXutil.trim( GXutil.str( A87MigrLegNumero, 8, 0))) ;
            GXv_char4[0] = AV52ParCod ;
            GXv_objcol_svchar5[0] = AV15errores ;
            GXv_objcol_svchar6[0] = AV43warnings ;
            GXv_char3[0] = "" ;
            GXv_boolean7[0] = false ;
            GXv_boolean8[0] = false ;
            GXv_boolean9[0] = false ;
            GXv_char10[0] = "" ;
            new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Parentesco", ""), A2079MigrLegFamParen, true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char4, GXv_objcol_svchar5, GXv_objcol_svchar6, GXv_char3, GXv_boolean7, GXv_boolean8, GXv_boolean9, GXv_char10) ;
            aimportarlegajosseleccionados.this.AV52ParCod = GXv_char4[0] ;
            AV15errores = GXv_objcol_svchar5[0] ;
            AV43warnings = GXv_objcol_svchar6[0] ;
            GXv_boolean9[0] = AV53FamAdherente ;
            GXv_objcol_svchar6[0] = AV15errores ;
            GXv_char10[0] = "" ;
            GXv_boolean8[0] = false ;
            new web.traducirsinoaboolean(remoteHandle, context).execute( AV12CliCod, A2082MigrLegFamAdh, httpContext.getMessage( "Adherente", ""), GXv_boolean9, GXv_objcol_svchar6, GXv_char10, GXv_boolean8) ;
            aimportarlegajosseleccionados.this.AV53FamAdherente = GXv_boolean9[0] ;
            AV15errores = GXv_objcol_svchar6[0] ;
            GXv_boolean9[0] = AV54FamDiscap ;
            GXv_objcol_svchar6[0] = AV15errores ;
            GXv_char10[0] = "" ;
            GXv_boolean8[0] = false ;
            new web.traducirsinoaboolean(remoteHandle, context).execute( AV12CliCod, A2086MigrLegFamDiscap, httpContext.getMessage( "Discapacitado", ""), GXv_boolean9, GXv_objcol_svchar6, GXv_char10, GXv_boolean8) ;
            aimportarlegajosseleccionados.this.AV54FamDiscap = GXv_boolean9[0] ;
            AV15errores = GXv_objcol_svchar6[0] ;
            AV51itemFamilia = (web.Sdtsdt_import_LegFam_sdt_import_LegFamItem)new web.Sdtsdt_import_LegFam_sdt_import_LegFamItem(remoteHandle, context);
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente( AV53FamAdherente );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap( AV54FamDiscap );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc( A2080MigrLegFamNroDoc );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan( A2081MigrLegFamDedGan );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod( AV52ParCod );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape( A2088MigrLegFamNomApe );
            AV51itemFamilia.setgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac( A2089MigrLegFamFecNac );
            AV50sdt_import_LegFam.add(AV51itemFamilia, 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV77GXLvl17 == 0 )
         {
         }
         /* Using cursor P000P3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV39EmpCod), Integer.valueOf(AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero())});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A87MigrLegNumero = P000P3_A87MigrLegNumero[0] ;
            A1EmpCod = P000P3_A1EmpCod[0] ;
            A3CliCod = P000P3_A3CliCod[0] ;
            A633MigrLegWarnings = P000P3_A633MigrLegWarnings[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "!WARNING AL COMIENZO ", "")+GXutil.trim( A633MigrLegWarnings)+httpContext.getMessage( " MigrLegNumero ", "")+GXutil.trim( GXutil.str( A87MigrLegNumero, 8, 0))) ;
            AV68MigrLegWarnings = A633MigrLegWarnings ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         GXv_int11[0] = AV29LegSexo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirsexo(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo(), GXv_int11, GXv_objcol_svchar6, GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV29LegSexo = GXv_int11[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int12[0] = AV26LegEstadoCivil ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirestadocivil(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil(), GXv_int12, GXv_objcol_svchar6, GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV26LegEstadoCivil = GXv_int12[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int12[0] = AV25LegDiscapacidad ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirsinoanum(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad(), httpContext.getMessage( "Discapacidad", ""), GXv_int12, GXv_objcol_svchar6, GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV25LegDiscapacidad = (byte)((byte)(GXv_int12[0])) ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int13[0] = AV12CliCod ;
         GXv_char10[0] = AV71LegModTra ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirmodotrabajo(remoteHandle, context).execute( GXv_int13, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra(), GXv_char10, GXv_objcol_svchar6, GXv_char4, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV12CliCod = GXv_int13[0] ;
         aimportarlegajosseleccionados.this.AV71LegModTra = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int13[0] = AV12CliCod ;
         GXv_int11[0] = AV24LegClase ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirclaselegajo(remoteHandle, context).execute( GXv_int13, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase(), GXv_int11, GXv_objcol_svchar6, GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV12CliCod = GXv_int13[0] ;
         aimportarlegajosseleccionados.this.AV24LegClase = GXv_int11[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int13[0] = AV12CliCod ;
         GXv_char10[0] = AV72LegTipoTarifa ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirtipotarifa(remoteHandle, context).execute( GXv_int13, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa(), GXv_char10, GXv_objcol_svchar6, GXv_char4, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV12CliCod = GXv_int13[0] ;
         aimportarlegajosseleccionados.this.AV72LegTipoTarifa = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_int11[0] = AV27LegFormaPago ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirformapago(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago(), GXv_int11, GXv_objcol_svchar6, GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV27LegFormaPago = GXv_int11[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_boolean9[0] = AV28LegSCVO ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean8[0] = false ;
         new web.traducirsinoaboolean(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo(), httpContext.getMessage( "SCVO", ""), GXv_boolean9, GXv_objcol_svchar6, GXv_char10, GXv_boolean8) ;
         aimportarlegajosseleccionados.this.AV28LegSCVO = GXv_boolean9[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_boolean9[0] = AV45tieneConyuge ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char10[0] = "" ;
         GXv_boolean8[0] = false ;
         new web.traducirsinoaboolean(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge(), httpContext.getMessage( "Tiene Conyuge", ""), GXv_boolean9, GXv_objcol_svchar6, GXv_char10, GXv_boolean8) ;
         aimportarlegajosseleccionados.this.AV45tieneConyuge = GXv_boolean9[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         GXv_char10[0] = AV23LegBanTipCuen ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         new web.traducirtipocuentabanco(remoteHandle, context).execute( AV12CliCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen(), GXv_char10, GXv_objcol_svchar6, GXv_char4, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV23LegBanTipCuen = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "TraducirMigracionCaracter AREA", "")) ;
         GXv_char10[0] = AV63codigoPalabra ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Actividad Laboral Clasificada", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV63codigoPalabra = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         AV64LegActClasNro = (int)(GXutil.lval( AV63codigoPalabra)) ;
         GXv_char10[0] = AV65LegPueAfiCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Puesto AFIP", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV65LegPueAfiCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV34SecCodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Area", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV34SecCodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_int12[0] = AV47PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int12) ;
         aimportarlegajosseleccionados.this.AV47PaiCod = GXv_int12[0] ;
         GXv_char10[0] = AV13ConveCodigo ;
         GXv_boolean9[0] = false ;
         new web.getconveniopordescrip(remoteHandle, context).execute( AV12CliCod, AV47PaiCod, "", GXutil.trim( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio()), GXv_char10, GXv_boolean9) ;
         aimportarlegajosseleccionados.this.AV13ConveCodigo = GXv_char10[0] ;
         GXv_char10[0] = AV13ConveCodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Convenio", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio(), false, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV13ConveCodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "llama con &itemImportacion.MigrLegCategoria ", "")+AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria()) ;
         GXv_char10[0] = AV38ZonCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Zona", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV38ZonCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV58auxDependencia ;
         new web.migrarmardependenciacategoria(remoteHandle, context).execute( AV13ConveCodigo, AV38ZonCod, GXv_char10) ;
         aimportarlegajosseleccionados.this.AV58auxDependencia = GXv_char10[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "antes de categoria errores ", "")+AV15errores.toJSonString(false)+httpContext.getMessage( " warnings ", "")+AV43warnings.toJSonString(false)+httpContext.getMessage( " &auxDependencia ", "")+AV58auxDependencia) ;
         GXv_char10[0] = AV11catcodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Categoria", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria(), false, AV58auxDependencia, AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV11catcodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "despues de categoria errores ", "")+AV15errores.toJSonString(false)+httpContext.getMessage( " warnings ", "")+AV43warnings.toJSonString(false)) ;
         AV58auxDependencia = AV34SecCodigo ;
         GXv_char10[0] = AV57MigrPuesto ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Puesto", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto(), false, AV58auxDependencia, AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV57MigrPuesto = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "recibe ", "")+AV11catcodigo) ;
         GXv_char10[0] = AV8BanCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Banco", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV8BanCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV10SinCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Sindicato", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato(), false, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV10SinCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "&sincod ", "")+GXutil.trim( AV10SinCod)) ;
         GXv_char10[0] = AV32OsoCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Obra Social", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV32OsoCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV21LegActCodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Actividad", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV21LegActCodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV31MprCod ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Modalidad", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV31MprCod = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV36SitCodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Situacion", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV36SitCodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         GXv_char10[0] = AV44CondiCodigoChar ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Condicion", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV44CondiCodigoChar = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         AV9CondiCodigo = (short)(GXutil.lval( AV44CondiCodigoChar)) ;
         GXv_char10[0] = AV35SinieCodigo ;
         GXv_objcol_svchar6[0] = AV15errores ;
         GXv_objcol_svchar5[0] = AV43warnings ;
         GXv_char4[0] = "" ;
         GXv_boolean9[0] = false ;
         GXv_boolean8[0] = false ;
         GXv_boolean7[0] = false ;
         GXv_char3[0] = "" ;
         new web.traducirmigracioncaracter(remoteHandle, context).execute( AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), httpContext.getMessage( "Siniestrado", ""), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado(), true, "", AV48algoritmoEquivalenciasUsar, "", "", GXv_char10, GXv_objcol_svchar6, GXv_objcol_svchar5, GXv_char4, GXv_boolean9, GXv_boolean8, GXv_boolean7, GXv_char3) ;
         aimportarlegajosseleccionados.this.AV35SinieCodigo = GXv_char10[0] ;
         AV15errores = GXv_objcol_svchar6[0] ;
         AV43warnings = GXv_objcol_svchar5[0] ;
         if ( AV15errores.size() > 0 )
         {
            AV14e = (short)(1) ;
            AV66auxError_Es = false ;
            while ( AV14e <= AV15errores.size() )
            {
               if ( GXutil.strcmp(GXutil.upper( GXutil.trim( (String)AV15errores.elementAt(-1+AV14e))), httpContext.getMessage( "LOS DATOS HAN SIDO AGREGADOS.", "")) != 0 )
               {
                  AV66auxError_Es = true ;
                  AV16errores_todos.add((String)AV15errores.elementAt(-1+AV14e), 0);
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "&errores.Item(&e) ", "")+(String)AV15errores.elementAt(-1+AV14e)) ;
               }
               AV14e = (short)(AV14e+1) ;
            }
            if ( AV66auxError_Es )
            {
               AV59conErrLeg.add((int)(AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero()), 0);
            }
         }
         else
         {
            GXv_char10[0] = AV55MigrLegApellido ;
            new web.capitalizartexto(remoteHandle, context).execute( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido(), GXv_char10) ;
            aimportarlegajosseleccionados.this.AV55MigrLegApellido = GXv_char10[0] ;
            GXv_char10[0] = AV56MigrLegNombre ;
            new web.capitalizartexto(remoteHandle, context).execute( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre(), GXv_char10) ;
            aimportarlegajosseleccionados.this.AV56MigrLegNombre = GXv_char10[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "&MigrLegWarnings ", "")+GXutil.trim( AV68MigrLegWarnings)) ;
            if ( ! (GXutil.strcmp("", AV68MigrLegWarnings)==0) )
            {
               AV67LegMigrWarn = GXutil.trim( AV68MigrLegWarnings) ;
               AV69auxWarnings = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV67LegMigrWarn,httpContext.getMessage( "<BR>", ""))) ;
               AV67LegMigrWarn = "" ;
               AV70a = (short)(1) ;
               while ( AV70a <= AV69auxWarnings.size() )
               {
                  if ( AV69auxWarnings.indexof(httpContext.getMessage( "creará", "")) == 0 )
                  {
                     AV67LegMigrWarn += GXutil.trim( (String)AV69auxWarnings.elementAt(-1+AV70a)) ;
                     if ( AV70a < AV69auxWarnings.size() )
                     {
                        AV67LegMigrWarn += ", " ;
                     }
                  }
                  AV70a = (short)(AV70a+1) ;
               }
            }
            else
            {
               AV67LegMigrWarn = "" ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "manda &&LegMigrWarn ", "")+GXutil.trim( AV67LegMigrWarn)) ;
            GXv_objcol_svchar6[0] = AV16errores_todos ;
            GXv_int13[0] = AV46LegNumero ;
            new web.legajoasignarbc(remoteHandle, context).execute( (short)(1), AV12CliCod, AV39EmpCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos(), AV55MigrLegApellido, AV56MigrLegNombre, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac(), AV29LegSexo, AV26LegEstadoCivil, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil(), "."))), AV25LegDiscapacidad, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso(), AV11catcodigo, AV34SecCodigo, AV30LpgCodigo, AV71LegModTra, AV24LegClase, AV72LegTipoTarifa, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico(), AV27LegFormaPago, AV8BanCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc(), AV23LegBanTipCuen, AV10SinCod, AV32OsoCod, AV33PmedCod, AV21LegActCodigo, AV31MprCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc(), AV38ZonCod, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu(), AV28LegSCVO, AV36SitCodigo, AV13ConveCodigo, AV9CondiCodigo, AV35SinieCodigo, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs(), AV57MigrPuesto, "", AV64LegActClasNro, AV65LegPueAfiCod, AV67LegMigrWarn, AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem(), GXv_objcol_svchar6, GXv_int13) ;
            AV16errores_todos = GXv_objcol_svchar6[0] ;
            aimportarlegajosseleccionados.this.AV46LegNumero = GXv_int13[0] ;
            if ( AV16errores_todos.size() == 0 )
            {
               AV42LegOrden = (short)(1) ;
               AV62famErrHay = false ;
               AV79GXV2 = 1 ;
               while ( AV79GXV2 <= AV50sdt_import_LegFam.size() )
               {
                  AV51itemFamilia = (web.Sdtsdt_import_LegFam_sdt_import_LegFamItem)((web.Sdtsdt_import_LegFam_sdt_import_LegFamItem)AV50sdt_import_LegFam.elementAt(-1+AV79GXV2));
                  AV42LegOrden = (short)(AV42LegOrden+1) ;
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Clicod( AV12CliCod );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Empcod( AV39EmpCod );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Legnumero( AV46LegNumero );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Legorden( AV42LegOrden );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Parcod( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Parcod() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famtomadeducimpgan() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famdiscap( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famdiscap() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famnrodoc( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnrodoc() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famadherente( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famadherente() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famnomape( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famnomape() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Famfecnac( AV51itemFamilia.getgxTv_Sdtsdt_import_LegFam_sdt_import_LegFamItem_Famfecnac() );
                  AV40LegajoFamilia.setgxTv_SdtLegajoFamilia_Guarcod_SetNull();
                  AV40LegajoFamilia.Save();
                  AV20l = (short)(1) ;
                  while ( AV20l <= AV40LegajoFamilia.GetMessages().size() )
                  {
                     if ( GXutil.strcmp(GXutil.upper( GXutil.trim( ((com.genexus.SdtMessages_Message)AV40LegajoFamilia.GetMessages().elementAt(-1+AV20l)).getgxTv_SdtMessages_Message_Description())), httpContext.getMessage( "LOS DATOS HAN SIDO AGREGADOS.", "")) != 0 )
                     {
                        AV16errores_todos.add(((com.genexus.SdtMessages_Message)AV40LegajoFamilia.GetMessages().elementAt(-1+AV20l)).getgxTv_SdtMessages_Message_Description(), 0);
                        AV62famErrHay = true ;
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "error fami 1 ", "")+GXutil.upper( GXutil.trim( ((com.genexus.SdtMessages_Message)AV40LegajoFamilia.GetMessages().elementAt(-1+AV20l)).getgxTv_SdtMessages_Message_Description()))) ;
                     }
                     AV20l = (short)(AV20l+1) ;
                  }
                  AV79GXV2 = (int)(AV79GXV2+1) ;
               }
               if ( AV62famErrHay )
               {
                  AV59conErrLeg.add((int)(AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero()), 0);
               }
            }
            else
            {
               AV59conErrLeg.add((int)(AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero()), 0);
            }
         }
         AV76GXV1 = (int)(AV76GXV1+1) ;
      }
      AV80GXV3 = 1 ;
      while ( AV80GXV3 <= AV18importacion_legajoWWSDT.size() )
      {
         AV19itemImportacion = (web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)((web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)AV18importacion_legajoWWSDT.elementAt(-1+AV80GXV3));
         AV60errorHay = false ;
         AV61f = (short)(1) ;
         while ( AV61f <= AV59conErrLeg.size() )
         {
            if ( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero() == ((Number) AV59conErrLeg.elementAt(-1+AV61f)).intValue() )
            {
               AV60errorHay = true ;
               if (true) break;
            }
            AV61f = (short)(AV61f+1) ;
         }
         if ( ! AV60errorHay )
         {
            new web.eliminarmigrleg(remoteHandle, context).execute( AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod(), AV19itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero()) ;
         }
         AV80GXV3 = (int)(AV80GXV3+1) ;
      }
      if ( AV16errores_todos.size() == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "aimportarlegajosseleccionados");
         if ( AV18importacion_legajoWWSDT.size() > 1 )
         {
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Se importaron los legajos correctamente", "")) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "Se importaron los legajos correctamente", "")) ;
         }
         else
         {
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Se importó el legajo correctamente", "")) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "Se importó el legajo correctamente", "")) ;
         }
      }
      else
      {
         AV17i = (short)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV75Pgmname, httpContext.getMessage( "&errores_todos ", "")+AV16errores_todos.toJSonString(false)) ;
         while ( AV17i <= AV16errores_todos.size() )
         {
            new web.alert(remoteHandle, context).execute( "error", (String)AV16errores_todos.elementAt(-1+AV17i)) ;
            AV17i = (short)(AV17i+1) ;
         }
      }
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(importarlegajosseleccionados.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aimportarlegajosseleccionados.this.AV18importacion_legajoWWSDT;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV49ParmValue = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV48algoritmoEquivalenciasUsar = "" ;
      AV75Pgmname = "" ;
      AV19itemImportacion = new web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem(remoteHandle, context);
      AV15errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50sdt_import_LegFam = new GXBaseCollection<web.Sdtsdt_import_LegFam_sdt_import_LegFamItem>(web.Sdtsdt_import_LegFam_sdt_import_LegFamItem.class, "sdt_import_LegFamItem", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P000P2_A87MigrLegNumero = new int[1] ;
      P000P2_A1EmpCod = new short[1] ;
      P000P2_A3CliCod = new int[1] ;
      P000P2_A633MigrLegWarnings = new String[] {""} ;
      P000P2_A2079MigrLegFamParen = new String[] {""} ;
      P000P2_A2082MigrLegFamAdh = new String[] {""} ;
      P000P2_A2086MigrLegFamDiscap = new String[] {""} ;
      P000P2_A2080MigrLegFamNroDoc = new String[] {""} ;
      P000P2_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P000P2_A2088MigrLegFamNomApe = new String[] {""} ;
      P000P2_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P000P2_A2078MigrLegFamSec = new short[1] ;
      A633MigrLegWarnings = "" ;
      A2079MigrLegFamParen = "" ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      AV52ParCod = "" ;
      AV51itemFamilia = new web.Sdtsdt_import_LegFam_sdt_import_LegFamItem(remoteHandle, context);
      P000P3_A87MigrLegNumero = new int[1] ;
      P000P3_A1EmpCod = new short[1] ;
      P000P3_A3CliCod = new int[1] ;
      P000P3_A633MigrLegWarnings = new String[] {""} ;
      AV68MigrLegWarnings = "" ;
      AV71LegModTra = "" ;
      AV72LegTipoTarifa = "" ;
      GXv_int11 = new byte[1] ;
      AV23LegBanTipCuen = "" ;
      AV63codigoPalabra = "" ;
      AV65LegPueAfiCod = "" ;
      AV34SecCodigo = "" ;
      GXv_int12 = new short[1] ;
      AV13ConveCodigo = "" ;
      AV38ZonCod = "" ;
      AV58auxDependencia = "" ;
      AV11catcodigo = "" ;
      AV57MigrPuesto = "" ;
      AV8BanCod = "" ;
      AV10SinCod = "" ;
      AV32OsoCod = "" ;
      AV21LegActCodigo = "" ;
      AV31MprCod = "" ;
      AV36SitCodigo = "" ;
      AV44CondiCodigoChar = "" ;
      AV35SinieCodigo = "" ;
      GXv_objcol_svchar5 = new GXSimpleCollection[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_char3 = new String[1] ;
      AV16errores_todos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59conErrLeg = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV55MigrLegApellido = "" ;
      AV56MigrLegNombre = "" ;
      GXv_char10 = new String[1] ;
      AV67LegMigrWarn = "" ;
      AV69auxWarnings = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30LpgCodigo = "" ;
      AV33PmedCod = "" ;
      GXv_objcol_svchar6 = new GXSimpleCollection[1] ;
      GXv_int13 = new int[1] ;
      AV40LegajoFamilia = new web.SdtLegajoFamilia(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.aimportarlegajosseleccionados__default(),
         new Object[] {
             new Object[] {
            P000P2_A87MigrLegNumero, P000P2_A1EmpCod, P000P2_A3CliCod, P000P2_A633MigrLegWarnings, P000P2_A2079MigrLegFamParen, P000P2_A2082MigrLegFamAdh, P000P2_A2086MigrLegFamDiscap, P000P2_A2080MigrLegFamNroDoc, P000P2_A2081MigrLegFamDedGan, P000P2_A2088MigrLegFamNomApe,
            P000P2_A2089MigrLegFamFecNac, P000P2_A2078MigrLegFamSec
            }
            , new Object[] {
            P000P3_A87MigrLegNumero, P000P3_A1EmpCod, P000P3_A3CliCod, P000P3_A633MigrLegWarnings
            }
         }
      );
      AV75Pgmname = "AImportarLegajosSeleccionados" ;
      /* GeneXus formulas. */
      AV75Pgmname = "AImportarLegajosSeleccionados" ;
      Gx_err = (short)(0) ;
   }

   private byte AV77GXLvl17 ;
   private byte AV29LegSexo ;
   private byte AV25LegDiscapacidad ;
   private byte AV24LegClase ;
   private byte AV27LegFormaPago ;
   private byte GXv_int11[] ;
   private short AV39EmpCod ;
   private short A1EmpCod ;
   private short A2078MigrLegFamSec ;
   private short AV26LegEstadoCivil ;
   private short AV47PaiCod ;
   private short GXv_int12[] ;
   private short AV9CondiCodigo ;
   private short AV14e ;
   private short AV70a ;
   private short AV42LegOrden ;
   private short AV20l ;
   private short AV61f ;
   private short AV17i ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV76GXV1 ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private int AV64LegActClasNro ;
   private int AV46LegNumero ;
   private int GXv_int13[] ;
   private int AV79GXV2 ;
   private int AV80GXV3 ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV48algoritmoEquivalenciasUsar ;
   private String AV75Pgmname ;
   private String scmdbuf ;
   private String A2082MigrLegFamAdh ;
   private String A2086MigrLegFamDiscap ;
   private String AV52ParCod ;
   private String AV71LegModTra ;
   private String AV72LegTipoTarifa ;
   private String AV23LegBanTipCuen ;
   private String AV63codigoPalabra ;
   private String AV65LegPueAfiCod ;
   private String AV34SecCodigo ;
   private String AV13ConveCodigo ;
   private String AV38ZonCod ;
   private String AV11catcodigo ;
   private String AV8BanCod ;
   private String AV10SinCod ;
   private String AV32OsoCod ;
   private String AV21LegActCodigo ;
   private String AV31MprCod ;
   private String AV36SitCodigo ;
   private String AV44CondiCodigoChar ;
   private String AV35SinieCodigo ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char10[] ;
   private String AV30LpgCodigo ;
   private String AV33PmedCod ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private boolean AV53FamAdherente ;
   private boolean AV54FamDiscap ;
   private boolean AV28LegSCVO ;
   private boolean AV45tieneConyuge ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean8[] ;
   private boolean GXv_boolean7[] ;
   private boolean AV66auxError_Es ;
   private boolean AV62famErrHay ;
   private boolean AV60errorHay ;
   private String AV49ParmValue ;
   private String A633MigrLegWarnings ;
   private String AV68MigrLegWarnings ;
   private String AV67LegMigrWarn ;
   private String A2079MigrLegFamParen ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String AV58auxDependencia ;
   private String AV57MigrPuesto ;
   private String AV55MigrLegApellido ;
   private String AV56MigrLegNombre ;
   private GXSimpleCollection<Integer> AV59conErrLeg ;
   private web.SdtLegajoFamilia AV40LegajoFamilia ;
   private GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P000P2_A87MigrLegNumero ;
   private short[] P000P2_A1EmpCod ;
   private int[] P000P2_A3CliCod ;
   private String[] P000P2_A633MigrLegWarnings ;
   private String[] P000P2_A2079MigrLegFamParen ;
   private String[] P000P2_A2082MigrLegFamAdh ;
   private String[] P000P2_A2086MigrLegFamDiscap ;
   private String[] P000P2_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] P000P2_A2081MigrLegFamDedGan ;
   private String[] P000P2_A2088MigrLegFamNomApe ;
   private java.util.Date[] P000P2_A2089MigrLegFamFecNac ;
   private short[] P000P2_A2078MigrLegFamSec ;
   private int[] P000P3_A87MigrLegNumero ;
   private short[] P000P3_A1EmpCod ;
   private int[] P000P3_A3CliCod ;
   private String[] P000P3_A633MigrLegWarnings ;
   private GXSimpleCollection<String> AV15errores ;
   private GXSimpleCollection<String> AV43warnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar5[] ;
   private GXSimpleCollection<String> AV16errores_todos ;
   private GXSimpleCollection<String> AV69auxWarnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar6[] ;
   private GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> AV18importacion_legajoWWSDT ;
   private GXBaseCollection<web.Sdtsdt_import_LegFam_sdt_import_LegFamItem> AV50sdt_import_LegFam ;
   private web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem AV19itemImportacion ;
   private web.Sdtsdt_import_LegFam_sdt_import_LegFamItem AV51itemFamilia ;
}

final  class aimportarlegajosseleccionados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000P2", "SELECT T1.MigrLegNumero, T1.EmpCod, T1.CliCod, T2.MigrLegWarnings, T1.MigrLegFamParen, T1.MigrLegFamAdh, T1.MigrLegFamDiscap, T1.MigrLegFamNroDoc, T1.MigrLegFamDedGan, T1.MigrLegFamNomApe, T1.MigrLegFamFecNac, T1.MigrLegFamSec FROM (importacion_legajoFamilia T1 INNER JOIN importacion_legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.MigrLegNumero = T1.MigrLegNumero) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.MigrLegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000P3", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegWarnings FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

