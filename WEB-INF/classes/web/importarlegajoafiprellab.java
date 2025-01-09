package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajoafiprellab extends GXProcedure
{
   public importarlegajoafiprellab( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajoafiprellab.class ), "" );
   }

   public importarlegajoafiprellab( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 ,
                            short aP3 ,
                            GXSimpleCollection<String>[] aP4 )
   {
      importarlegajoafiprellab.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             short[] aP5 )
   {
      importarlegajoafiprellab.this.AV12CliCod = aP0;
      importarlegajoafiprellab.this.AV16EmpCod = aP1;
      importarlegajoafiprellab.this.AV47ImpLiqSec = aP2;
      importarlegajoafiprellab.this.AV46ImpLiqLSDSec = aP3;
      importarlegajoafiprellab.this.aP4 = aP4;
      importarlegajoafiprellab.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, "1") ;
      AV68vez = (short)(1) ;
      AV62seguir = true ;
      AV49IsOk = true ;
      GXt_int1 = (int)(AV94ultimoId) ;
      GXv_int2[0] = GXt_int1 ;
      new web.obtienesiguientelegajo(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int2) ;
      importarlegajoafiprellab.this.GXt_int1 = GXv_int2[0] ;
      AV94ultimoId = GXt_int1 ;
      while ( ( AV68vez <= 2 ) && ( AV62seguir ) )
      {
         if ( AV18errores.size() > 0 )
         {
            if (true) break;
         }
         AV18errores.clear();
         AV9ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV105GXLvl14 = (byte)(0) ;
         /* Using cursor P027O2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV16EmpCod), Short.valueOf(AV47ImpLiqSec), Short.valueOf(AV46ImpLiqLSDSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A704ImpLiqLSDSec = P027O2_A704ImpLiqLSDSec[0] ;
            A88ImpLiqSec = P027O2_A88ImpLiqSec[0] ;
            A1EmpCod = P027O2_A1EmpCod[0] ;
            A3CliCod = P027O2_A3CliCod[0] ;
            A706ImpLiqLSDFileName = P027O2_A706ImpLiqLSDFileName[0] ;
            A707ImpLiqLSDFileType = P027O2_A707ImpLiqLSDFileType[0] ;
            A705ImpLiqLSDFile = P027O2_A705ImpLiqLSDFile[0] ;
            A708ImpLiqLSDFileNameAndType = P027O2_A708ImpLiqLSDFileNameAndType[0] ;
            AV105GXLvl14 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, "2") ;
            AV24File.setSource( A705ImpLiqLSDFile );
            if ( AV24File.exists() )
            {
               AV22f = (short)(0) ;
               AV67varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV24File.readAllLines()) ;
               AV13completo = false ;
               AV10algunoCompleto = false ;
               AV106GXV1 = 1 ;
               while ( AV106GXV1 <= AV67varcharcollection.size() )
               {
                  AV25fileLine = (String)AV67varcharcollection.elementAt(-1+AV106GXV1) ;
                  AV22f = (short)(AV22f+1) ;
                  if ( ( AV22f == 1 ) && ( GXutil.strcmp(GXutil.trim( AV25fileLine), httpContext.getMessage( "CUIL        APELLIDO Y NOMBRE                                           OBRA SOCIAL                                                                                                                                                     MODAL. CONTRATO                                                                                     ACTIVIDAD LABORAL                                           PUESTO DESEMP.                                                                                                                                                                                                                                                 RETRIB. PACTADA         MOD. LIQ.                     TRAB. AGROP. FECHA INICIO FECHA DE FIN SITUACION De BAJA                                                     CONVENIO COLECTIVO                                                    CATEGORIA                                                                       TIPO SERVICIO", "")) != 0 ) )
                  {
                     AV19errorFormato = httpContext.getMessage( "No coincide la primera línea con el formato esperado", "") ;
                     /* Execute user subroutine: 'FORMATO INVÁLIDO' */
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
                     if ( AV22f > 1 )
                     {
                        AV19errorFormato = "" ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fila ", "")+GXutil.trim( GXutil.str( AV22f, 4, 0))+" "+GXutil.trim( AV25fileLine)) ;
                        AV87MigrLegCUIL = GXutil.substring( AV25fileLine, 1, 11) ;
                        AV81LegCUIL = GXutil.lval( AV87MigrLegCUIL) ;
                        AV82LegNomApe = GXutil.substring( AV25fileLine, 13, 60) ;
                        GXv_char3[0] = AV83LegNombre ;
                        GXv_char4[0] = AV84LegApellido ;
                        new web.desglosarnombreyapellido(remoteHandle, context).execute( AV82LegNomApe, GXv_char3, GXv_char4) ;
                        importarlegajoafiprellab.this.AV83LegNombre = GXv_char3[0] ;
                        importarlegajoafiprellab.this.AV84LegApellido = GXv_char4[0] ;
                        AV85OsoDescrip = GXutil.substring( AV25fileLine, 73, 160) ;
                        AV92MigrLegModalidad = GXutil.substring( AV25fileLine, 233, 100) ;
                        if ( GXutil.strSearch( AV92MigrLegModalidad, "/", 1) != 0 )
                        {
                           AV92MigrLegModalidad = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV92MigrLegModalidad,"/")).elementAt(-1+1) ;
                        }
                        AV101MigrLegPueAfip = GXutil.substring( AV25fileLine, 393, 255) ;
                        AV90MigrLegConvenio = GXutil.substring( AV25fileLine, 811, 70) ;
                        if ( (GXutil.strcmp("", AV90MigrLegConvenio)==0) || ( GXutil.strSearch( GXutil.upper( AV90MigrLegConvenio), httpContext.getMessage( "EXCLUIDO DE", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV90MigrLegConvenio), httpContext.getMessage( "FUERA DE", ""), 1) != 0 ) )
                        {
                           AV38ImpLiqDetImp = GXutil.substring( AV25fileLine, 648, 24) ;
                           GXt_char5 = AV90MigrLegConvenio ;
                           GXv_char4[0] = GXt_char5 ;
                           new web.textofueradeconvenio(remoteHandle, context).execute( AV12CliCod, GXv_char4) ;
                           importarlegajoafiprellab.this.GXt_char5 = GXv_char4[0] ;
                           AV90MigrLegConvenio = GXt_char5 ;
                        }
                        else
                        {
                           AV38ImpLiqDetImp = "" ;
                        }
                        AV89modoLiqPalabra = GXutil.substring( AV25fileLine, 672, 30) ;
                        AV86LegFecIngreso = localUtil.ctod( GXutil.substring( AV25fileLine, 715, 10), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
                        AV100MigrLegActLabClas = GXutil.substring( AV25fileLine, 333, 60) ;
                        AV91MigrLegCategoria = GXutil.substring( AV25fileLine, 881, 70) ;
                        AV10algunoCompleto = true ;
                        if ( AV68vez == 1 )
                        {
                           if ( (0==AV81LegCUIL) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró CUIL \"", "") + AV87MigrLegCUIL + "\" (" + GXutil.str( AV81LegCUIL, 11, 0) + ")" ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV82LegNomApe)==0) || ( CommonUtil.decimalVal( AV82LegNomApe, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de nombre y apellido en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV85OsoDescrip)==0) || ( CommonUtil.decimalVal( AV85OsoDescrip, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de obra social en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV86LegFecIngreso)) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de fecha de ingreso", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV38ImpLiqDetImp)==0) && (GXutil.strcmp("", AV90MigrLegConvenio)==0) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato remuneración pactada", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV89modoLiqPalabra)==0) || ( CommonUtil.decimalVal( AV89modoLiqPalabra, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de modo de liquidación en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV90MigrLegConvenio)==0) || ( CommonUtil.decimalVal( AV90MigrLegConvenio, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de convenio colectivo de trabajo en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV91MigrLegCategoria)==0) || ( CommonUtil.decimalVal( AV91MigrLegCategoria, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de categoría en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                           }
                           if ( (GXutil.strcmp("", AV92MigrLegModalidad)==0) || ( CommonUtil.decimalVal( AV92MigrLegModalidad, ".").doubleValue() > 0 ) )
                           {
                              AV19errorFormato = httpContext.getMessage( "No se encontró dato de modalidad de contrato en txt", "") ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
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
                           new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "alta &MigrLegCUIL ", "")+AV87MigrLegCUIL+httpContext.getMessage( " &ImpLiqLSDSec ", "")+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0))) ;
                           /* Execute user subroutine: 'LOAD KEY' */
                           S141 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           /* Execute user subroutine: 'ASIGNAR' */
                           S121 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           /* Execute user subroutine: 'SAVE' */
                           S151 ();
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
                  if ( ! AV49IsOk )
                  {
                     if (true) break;
                  }
                  AV106GXV1 = (int)(AV106GXV1+1) ;
               }
               if ( ! AV10algunoCompleto )
               {
                  AV19errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "fi 9", "")) ;
                  /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               AV24File.close();
            }
            else
            {
               AV18errores.add(httpContext.getMessage( "No se pudo abrir el archivo ", "")+GXutil.trim( A708ImpLiqLSDFileNameAndType), 0);
            }
            if ( ( AV18errores.size() == 0 ) && ( AV68vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV18errores.size() > 0 ) && ( AV68vez == 1 ) )
               {
                  AV62seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV105GXLvl14 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0))) ;
            AV18errores.add(httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0)), 0);
         }
         if ( ! AV49IsOk )
         {
            if (true) break;
         }
         AV68vez = (short)(AV68vez+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "isok", "")+GXutil.trim( GXutil.booltostr( AV49IsOk))) ;
      if ( AV18errores.size() > 0 )
      {
         AV15e = (short)(1) ;
         AV18errores.sort("");
         while ( AV15e <= AV18errores.size() )
         {
            if ( GXutil.strcmp((String)AV18errores.elementAt(-1+AV15e), AV8ultiError) == 0 )
            {
               AV18errores.removeItem(AV15e);
            }
            else
            {
               AV8ultiError = (String)AV18errores.elementAt(-1+AV15e) ;
               AV15e = (short)(AV15e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV49IsOk = false ;
      AV17error = httpContext.getMessage( "Archivo con formato inválido ", "") ;
      if ( ! (GXutil.strcmp("", AV19errorFormato)==0) )
      {
         AV17error += "(" + GXutil.trim( AV19errorFormato) + ")" ;
      }
      AV18errores.add(AV17error, 0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "formainv ", "")+AV17error) ;
   }

   public void S121( )
   {
      /* 'ASIGNAR' Routine */
      returnInSub = false ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( true );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegconvenio( GXutil.trim( AV90MigrLegConvenio) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas( GXutil.trim( AV100MigrLegActLabClas) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegpueafip( GXutil.trim( AV101MigrLegPueAfip) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcategoria( GXutil.trim( AV91MigrLegCategoria) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( GXutil.trim( AV92MigrLegModalidad) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( false );
      AV97que = httpContext.getMessage( "Modalidad", "") ;
      /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
      S131 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV89modoLiqPalabra, httpContext.getMessage( "MES", "")) == 0 )
      {
         AV89modoLiqPalabra = httpContext.getMessage( "Mensual", "") ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( "P" );
      }
      else
      {
         AV89modoLiqPalabra = httpContext.getMessage( "Quincenal", "") ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( "H" );
      }
      GXv_char4[0] = AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegmodtra() ;
      new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, httpContext.getMessage( "Relación laboral", ""), GXv_char4) ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodtra( GXv_char4[0] );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclase( GXutil.trim( AV89modoLiqPalabra) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclasedef( false );
      AV97que = httpContext.getMessage( "Frecuencia de pago", "") ;
      /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
      S131 ();
      if (returnInSub) return;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegfecnac())) )
      {
         GXt_date6 = GXutil.nullDate() ;
         GXv_date7[0] = GXt_date6 ;
         new web.fecnacpredetimpor(remoteHandle, context).execute( GXv_date7) ;
         importarlegajoafiprellab.this.GXt_date6 = GXv_date7[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( GXt_date6 );
      }
      if ( (GXutil.strcmp("", AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid())==0) )
      {
         GXv_int8[0] = AV94ultimoId ;
         GXv_char4[0] = AV95LegId ;
         new web.getnextlegajoidsinrepetir(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int8, GXv_char4) ;
         importarlegajoafiprellab.this.AV94ultimoId = GXv_int8[0] ;
         importarlegajoafiprellab.this.AV95LegId = GXv_char4[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( AV95LegId );
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "Set record values &importacion_legajo.MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( GXutil.trim( GXutil.str( AV81LegCUIL, 11, 0)) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXutil.trim( AV83LegNombre) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXutil.trim( AV84LegApellido) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( GXutil.trim( AV85OsoDescrip) );
      if ( ! (GXutil.strcmp("", AV85OsoDescrip)==0) )
      {
         GXt_char5 = "" ;
         GXv_char4[0] = GXt_char5 ;
         new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Obra social", ""), GXv_char4) ;
         importarlegajoafiprellab.this.GXt_char5 = GXv_char4[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), GXt_char5+httpContext.getMessage( " <BR>", ""), "") );
      }
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV86LegFecIngreso );
      if ( ! (GXutil.strcmp("", AV38ImpLiqDetImp)==0) )
      {
         GXv_Sdtimportacion_legajo9[0] = AV48importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo9, AV38ImpLiqDetImp, AV86LegFecIngreso) ;
         AV48importacion_legajo = GXv_Sdtimportacion_legajo9[0] ;
      }
      else
      {
         GXv_Sdtimportacion_legajo9[0] = AV48importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo9, "", AV86LegFecIngreso) ;
         AV48importacion_legajo = GXv_Sdtimportacion_legajo9[0] ;
      }
   }

   public void S141( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV55MigrLegNumero ;
      new web.getmigrlegporcuil(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV87MigrLegCUIL, GXv_int2) ;
      importarlegajoafiprellab.this.AV55MigrLegNumero = GXv_int2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&MigrLegCUIL ", "")+AV87MigrLegCUIL+httpContext.getMessage( " trae &MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV55MigrLegNumero, 8, 0))) ;
      AV48importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      if ( (0==AV55MigrLegNumero) )
      {
         AV21existe = false ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Clicod( AV12CliCod );
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Empcod( AV16EmpCod );
         GXv_int2[0] = AV55MigrLegNumero ;
         new web.obtieneultimolegajomigracion(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int2) ;
         importarlegajoafiprellab.this.AV55MigrLegNumero = GXv_int2[0] ;
         AV55MigrLegNumero = (int)(AV55MigrLegNumero+1) ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnumero( AV55MigrLegNumero );
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "existe migrleg", "")) ;
         AV21existe = true ;
         AV48importacion_legajo.Load(AV12CliCod, AV16EmpCod, AV55MigrLegNumero);
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "load &importacion_legajo ", "")+GXutil.trim( GXutil.str( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnumero(), 8, 0))+httpContext.getMessage( " &importacion_legajo MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV55MigrLegNumero, 8, 0))) ;
   }

   public void S151( )
   {
      /* 'SAVE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save &importacion_legajo.MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      if ( ! AV21existe )
      {
         AV48importacion_legajo.Save();
      }
      else
      {
         AV48importacion_legajo.Update();
      }
      if ( ! AV48importacion_legajo.Success() )
      {
         AV52Messages = AV48importacion_legajo.GetMessages() ;
         AV49IsOk = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save 3", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV104Pgmname, httpContext.getMessage( "save 4", "")) ;
      }
   }

   public void S131( )
   {
      /* 'SACAR WARNING DEFAULT' Routine */
      returnInSub = false ;
      GXt_char5 = AV96mensaje ;
      GXt_char10 = AV96mensaje ;
      GXv_char4[0] = GXt_char10 ;
      new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV97que, GXv_char4) ;
      importarlegajoafiprellab.this.GXt_char10 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char5 ;
      new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, AV97que, GXt_char10, GXv_char3) ;
      importarlegajoafiprellab.this.GXt_char5 = GXv_char3[0] ;
      AV96mensaje = GXt_char5 ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), AV96mensaje, "") );
   }

   protected void cleanup( )
   {
      this.aP4[0] = importarlegajoafiprellab.this.AV18errores;
      this.aP5[0] = importarlegajoafiprellab.this.AV11altas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Pgmname = "" ;
      AV9ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P027O2_A704ImpLiqLSDSec = new short[1] ;
      P027O2_A88ImpLiqSec = new short[1] ;
      P027O2_A1EmpCod = new short[1] ;
      P027O2_A3CliCod = new int[1] ;
      P027O2_A706ImpLiqLSDFileName = new String[] {""} ;
      P027O2_A707ImpLiqLSDFileType = new String[] {""} ;
      P027O2_A705ImpLiqLSDFile = new String[] {""} ;
      P027O2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      AV24File = new com.genexus.util.GXFile();
      AV67varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25fileLine = "" ;
      AV19errorFormato = "" ;
      AV87MigrLegCUIL = "" ;
      AV82LegNomApe = "" ;
      AV83LegNombre = "" ;
      AV84LegApellido = "" ;
      AV85OsoDescrip = "" ;
      AV92MigrLegModalidad = "" ;
      AV101MigrLegPueAfip = "" ;
      AV90MigrLegConvenio = "" ;
      AV38ImpLiqDetImp = "" ;
      AV89modoLiqPalabra = "" ;
      AV86LegFecIngreso = GXutil.nullDate() ;
      AV100MigrLegActLabClas = "" ;
      AV91MigrLegCategoria = "" ;
      AV8ultiError = "" ;
      AV17error = "" ;
      AV48importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      AV97que = "" ;
      GXt_date6 = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_int8 = new long[1] ;
      AV95LegId = "" ;
      GXv_Sdtimportacion_legajo9 = new web.Sdtimportacion_legajo[1] ;
      GXv_int2 = new int[1] ;
      AV52Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV96mensaje = "" ;
      GXt_char5 = "" ;
      GXt_char10 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajoafiprellab__default(),
         new Object[] {
             new Object[] {
            P027O2_A704ImpLiqLSDSec, P027O2_A88ImpLiqSec, P027O2_A1EmpCod, P027O2_A3CliCod, P027O2_A706ImpLiqLSDFileName, P027O2_A707ImpLiqLSDFileType, P027O2_A705ImpLiqLSDFile, P027O2_A708ImpLiqLSDFileNameAndType
            }
         }
      );
      AV104Pgmname = "ImportarLegajoAfipRelLab" ;
      /* GeneXus formulas. */
      AV104Pgmname = "ImportarLegajoAfipRelLab" ;
      Gx_err = (short)(0) ;
   }

   private byte AV105GXLvl14 ;
   private short AV16EmpCod ;
   private short AV47ImpLiqSec ;
   private short AV46ImpLiqLSDSec ;
   private short AV11altas ;
   private short AV68vez ;
   private short A704ImpLiqLSDSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV22f ;
   private short AV15e ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int GXt_int1 ;
   private int A3CliCod ;
   private int AV106GXV1 ;
   private int AV55MigrLegNumero ;
   private int GXv_int2[] ;
   private long AV94ultimoId ;
   private long AV81LegCUIL ;
   private long GXv_int8[] ;
   private String AV104Pgmname ;
   private String scmdbuf ;
   private String A707ImpLiqLSDFileType ;
   private String AV25fileLine ;
   private String AV87MigrLegCUIL ;
   private String AV38ImpLiqDetImp ;
   private String AV89modoLiqPalabra ;
   private String AV97que ;
   private String AV95LegId ;
   private String GXt_char5 ;
   private String GXt_char10 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV9ahora ;
   private java.util.Date AV86LegFecIngreso ;
   private java.util.Date GXt_date6 ;
   private java.util.Date GXv_date7[] ;
   private boolean AV62seguir ;
   private boolean AV49IsOk ;
   private boolean AV13completo ;
   private boolean AV10algunoCompleto ;
   private boolean returnInSub ;
   private boolean AV21existe ;
   private String A705ImpLiqLSDFile ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String AV19errorFormato ;
   private String AV82LegNomApe ;
   private String AV83LegNombre ;
   private String AV84LegApellido ;
   private String AV85OsoDescrip ;
   private String AV92MigrLegModalidad ;
   private String AV101MigrLegPueAfip ;
   private String AV90MigrLegConvenio ;
   private String AV100MigrLegActLabClas ;
   private String AV91MigrLegCategoria ;
   private String AV8ultiError ;
   private String AV17error ;
   private String AV96mensaje ;
   private com.genexus.util.GXFile AV24File ;
   private web.Sdtimportacion_legajo AV48importacion_legajo ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P027O2_A704ImpLiqLSDSec ;
   private short[] P027O2_A88ImpLiqSec ;
   private short[] P027O2_A1EmpCod ;
   private int[] P027O2_A3CliCod ;
   private String[] P027O2_A706ImpLiqLSDFileName ;
   private String[] P027O2_A707ImpLiqLSDFileType ;
   private String[] P027O2_A705ImpLiqLSDFile ;
   private String[] P027O2_A708ImpLiqLSDFileNameAndType ;
   private GXSimpleCollection<String> AV67varcharcollection ;
   private GXSimpleCollection<String> AV18errores ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV52Messages ;
   private web.Sdtimportacion_legajo GXv_Sdtimportacion_legajo9[] ;
}

final  class importarlegajoafiprellab__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027O2", "SELECT ImpLiqLSDSec, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDFileName, ImpLiqLSDFileType, ImpLiqLSDFile, ImpLiqLSDFileNameAndType FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getBLOBFile(7, rslt.getString(6, 20), rslt.getVarchar(5));
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

