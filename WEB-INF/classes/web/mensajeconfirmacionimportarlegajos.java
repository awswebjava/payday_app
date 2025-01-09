package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeconfirmacionimportarlegajos extends GXProcedure
{
   public mensajeconfirmacionimportarlegajos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeconfirmacionimportarlegajos.class ), "" );
   }

   public mensajeconfirmacionimportarlegajos( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> aP2 )
   {
      mensajeconfirmacionimportarlegajos.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> aP2 ,
                             String[] aP3 )
   {
      mensajeconfirmacionimportarlegajos.this.AV11CliCod = aP0;
      mensajeconfirmacionimportarlegajos.this.AV35EmpCod = aP1;
      mensajeconfirmacionimportarlegajos.this.AV9importacion_legajoWWSDT = aP2;
      mensajeconfirmacionimportarlegajos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = "" ;
      AV29confirmaciones.clear();
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV9importacion_legajoWWSDT.size() )
      {
         AV10itemImportacion = (web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)((web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)AV9importacion_legajoWWSDT.elementAt(-1+AV41GXV1));
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea())==0) )
         {
            GXt_char1 = AV15MigrLegArea ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV15MigrLegArea = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getseccionpordescrip(remoteHandle, context).execute( AV11CliCod, AV15MigrLegArea, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Area", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea(), true, true)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago())==0) )
         {
            GXt_char1 = AV17MigrLegLugarDePago ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV17MigrLegLugarDePago = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getlugpagpordescrip(remoteHandle, context).execute( AV11CliCod, AV17MigrLegLugarDePago, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Lugar de Pago", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago(), true, true)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco())==0) )
         {
            GXt_char1 = AV28MigrLegBanco ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV28MigrLegBanco = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getbancopordescrip(remoteHandle, context).execute( AV11CliCod, AV28MigrLegBanco, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Banco", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco(), true, true)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial())==0) )
         {
            GXt_boolean4 = AV14MigrEncontroOsoSigla ;
            GXv_boolean3[0] = GXt_boolean4 ;
            new web.getmigrencontroososigla(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod(), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod(), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.GXt_boolean4 = GXv_boolean3[0] ;
            AV14MigrEncontroOsoSigla = GXt_boolean4 ;
            GXt_char1 = AV26MigrLegObraSocial ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV26MigrLegObraSocial = GXt_char1 ;
            if ( AV14MigrEncontroOsoSigla )
            {
               GXv_char2[0] = "" ;
               GXv_boolean3[0] = AV13existe ;
               new web.getobrasocialporsigla(remoteHandle, context).execute( AV11CliCod, AV26MigrLegObraSocial, GXv_char2, GXv_boolean3) ;
               mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            }
            else
            {
               GXt_boolean4 = AV37MigrEncontroOsoAfip ;
               GXv_boolean3[0] = GXt_boolean4 ;
               new web.getmigrencontroosoafip(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod(), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod(), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero(), GXv_boolean3) ;
               mensajeconfirmacionimportarlegajos.this.GXt_boolean4 = GXv_boolean3[0] ;
               AV37MigrEncontroOsoAfip = GXt_boolean4 ;
               if ( AV37MigrEncontroOsoAfip )
               {
                  GXv_char2[0] = "" ;
                  GXv_boolean3[0] = AV13existe ;
                  new web.getobrasocialporcodigoafip(remoteHandle, context).execute( AV11CliCod, AV26MigrLegObraSocial, GXv_char2, GXv_boolean3) ;
                  mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
               }
               else
               {
                  GXv_char2[0] = "" ;
                  GXv_boolean3[0] = AV13existe ;
                  new web.getobrasocialpordescrip(remoteHandle, context).execute( AV11CliCod, AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(), GXv_char2, GXv_boolean3) ;
                  mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
               }
            }
            if ( ! AV13existe )
            {
               GXv_char2[0] = AV38auxDescrip ;
               new web.reemplazosningunos(remoteHandle, context).execute( AV11CliCod, AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(), GXv_char2) ;
               mensajeconfirmacionimportarlegajos.this.AV38auxDescrip = GXv_char2[0] ;
               if ( ! (GXutil.strcmp("", AV38auxDescrip)==0) )
               {
                  AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Obra Social", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial(), true, true)+". ", 0);
               }
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico())==0) )
         {
            GXt_char1 = AV25MigrLegPlanMedico ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV25MigrLegPlanMedico = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getplanmedicopordescrip(remoteHandle, context).execute( AV11CliCod, AV25MigrLegPlanMedico, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Plan Médico", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico(), true, true)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad())==0) )
         {
            GXt_char1 = AV24MigrLegActividad ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV24MigrLegActividad = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getactividadpordescrip(remoteHandle, context).execute( AV24MigrLegActividad, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Actividad", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad(), true, false)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad())==0) )
         {
            GXt_char1 = AV23MigrLegModalidad ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV23MigrLegModalidad = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getmodalidadpordescrip(remoteHandle, context).execute( AV23MigrLegModalidad, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Modalidad de Contratación", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad(), true, false)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona())==0) )
         {
            GXt_char1 = AV22MigrLegZona ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV22MigrLegZona = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getzonapordescrip(remoteHandle, context).execute( AV22MigrLegZona, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Zona", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona(), true, false)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista())==0) )
         {
            GXt_char1 = AV21MigrLegSituacionRevista ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV21MigrLegSituacionRevista = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getsituacionpordescrip(remoteHandle, context).execute( AV21MigrLegSituacionRevista, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Situación de Revista", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista(), true, false)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion())==0) )
         {
            GXt_char1 = AV19MigrLegCondicion ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV19MigrLegCondicion = GXt_char1 ;
            GXv_int5[0] = (short)(0) ;
            GXv_boolean3[0] = AV13existe ;
            new web.getcondicionpordescrip(remoteHandle, context).execute( AV19MigrLegCondicion, GXv_int5, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Condición", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion(), true, false)+". ", 0);
            }
         }
         if ( ! (GXutil.strcmp("", AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado())==0) )
         {
            GXt_char1 = AV18MigrLegSiniestrado ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado(), GXv_char2) ;
            mensajeconfirmacionimportarlegajos.this.GXt_char1 = GXv_char2[0] ;
            AV18MigrLegSiniestrado = GXt_char1 ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV13existe ;
            new web.getsiniestradopordescrip(remoteHandle, context).execute( AV18MigrLegSiniestrado, GXv_char2, GXv_boolean3) ;
            mensajeconfirmacionimportarlegajos.this.AV13existe = GXv_boolean3[0] ;
            if ( ! AV13existe )
            {
               AV29confirmaciones.add(new web.mensajesecreararegistro(remoteHandle, context).executeUdp( AV11CliCod, httpContext.getMessage( "Siniestrado", ""), AV10itemImportacion.getgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado(), true, false)+". ", 0);
            }
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
      AV8texto += httpContext.getMessage( "¿Confirma importar los legajos seleccionados?", "") ;
      if ( AV29confirmaciones.size() > 0 )
      {
         AV8texto += "               " ;
         AV30i = (short)(1) ;
         AV29confirmaciones.sort("");
         while ( AV30i <= AV29confirmaciones.size() )
         {
            if ( GXutil.strcmp((String)AV29confirmaciones.elementAt(-1+AV30i), AV31ultima) != 0 )
            {
               AV8texto += (String)AV29confirmaciones.elementAt(-1+AV30i) ;
            }
            AV31ultima = (String)AV29confirmaciones.elementAt(-1+AV30i) ;
            AV30i = (short)(AV30i+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = mensajeconfirmacionimportarlegajos.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      AV29confirmaciones = new GXSimpleCollection<String>(String.class, "internal", "");
      AV10itemImportacion = new web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem(remoteHandle, context);
      AV15MigrLegArea = "" ;
      AV17MigrLegLugarDePago = "" ;
      AV28MigrLegBanco = "" ;
      AV26MigrLegObraSocial = "" ;
      AV38auxDescrip = "" ;
      AV25MigrLegPlanMedico = "" ;
      AV24MigrLegActividad = "" ;
      AV23MigrLegModalidad = "" ;
      AV22MigrLegZona = "" ;
      AV21MigrLegSituacionRevista = "" ;
      AV19MigrLegCondicion = "" ;
      GXv_int5 = new short[1] ;
      AV18MigrLegSiniestrado = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV31ultima = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXv_int5[] ;
   private short AV30i ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV41GXV1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV31ultima ;
   private boolean AV13existe ;
   private boolean AV14MigrEncontroOsoSigla ;
   private boolean AV37MigrEncontroOsoAfip ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean3[] ;
   private String AV8texto ;
   private String AV15MigrLegArea ;
   private String AV17MigrLegLugarDePago ;
   private String AV28MigrLegBanco ;
   private String AV26MigrLegObraSocial ;
   private String AV38auxDescrip ;
   private String AV25MigrLegPlanMedico ;
   private String AV24MigrLegActividad ;
   private String AV23MigrLegModalidad ;
   private String AV22MigrLegZona ;
   private String AV21MigrLegSituacionRevista ;
   private String AV19MigrLegCondicion ;
   private String AV18MigrLegSiniestrado ;
   private String[] aP3 ;
   private GXSimpleCollection<String> AV29confirmaciones ;
   private GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> AV9importacion_legajoWWSDT ;
   private web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem AV10itemImportacion ;
}

