package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajoafiprellab2 extends GXProcedure
{
   public importarlegajoafiprellab2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajoafiprellab2.class ), "" );
   }

   public importarlegajoafiprellab2( int remoteHandle ,
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
      importarlegajoafiprellab2.this.aP5 = new short[] {0};
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
      importarlegajoafiprellab2.this.AV12CliCod = aP0;
      importarlegajoafiprellab2.this.AV16EmpCod = aP1;
      importarlegajoafiprellab2.this.AV47ImpLiqSec = aP2;
      importarlegajoafiprellab2.this.AV46ImpLiqLSDSec = aP3;
      importarlegajoafiprellab2.this.aP4 = aP4;
      importarlegajoafiprellab2.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, "1") ;
      AV68vez = (short)(1) ;
      AV62seguir = true ;
      AV49IsOk = true ;
      GXt_int1 = (int)(AV94ultimoId) ;
      GXv_int2[0] = GXt_int1 ;
      new web.obtienesiguientelegajo(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int2) ;
      importarlegajoafiprellab2.this.GXt_int1 = GXv_int2[0] ;
      AV94ultimoId = GXt_int1 ;
      while ( ( AV68vez <= 2 ) && ( AV62seguir ) )
      {
         if ( AV18errores.size() > 0 )
         {
            if (true) break;
         }
         AV18errores.clear();
         AV9ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV116GXLvl14 = (byte)(0) ;
         /* Using cursor P027N2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV16EmpCod), Short.valueOf(AV47ImpLiqSec), Short.valueOf(AV46ImpLiqLSDSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A704ImpLiqLSDSec = P027N2_A704ImpLiqLSDSec[0] ;
            A88ImpLiqSec = P027N2_A88ImpLiqSec[0] ;
            A1EmpCod = P027N2_A1EmpCod[0] ;
            A3CliCod = P027N2_A3CliCod[0] ;
            A706ImpLiqLSDFileName = P027N2_A706ImpLiqLSDFileName[0] ;
            A707ImpLiqLSDFileType = P027N2_A707ImpLiqLSDFileType[0] ;
            A705ImpLiqLSDFile = P027N2_A705ImpLiqLSDFile[0] ;
            A708ImpLiqLSDFileNameAndType = P027N2_A708ImpLiqLSDFileNameAndType[0] ;
            AV116GXLvl14 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, "2") ;
            AV24File.setSource( A705ImpLiqLSDFile );
            if ( AV24File.exists() )
            {
               AV22f = (short)(0) ;
               AV67varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV24File.readAllLines()) ;
               AV13completo = false ;
               AV10algunoCompleto = false ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "inicializa algunocompleto en ", "")+GXutil.trim( GXutil.booltostr( AV10algunoCompleto))) ;
               AV117GXV1 = 1 ;
               while ( AV117GXV1 <= AV67varcharcollection.size() )
               {
                  AV25fileLine = (String)AV67varcharcollection.elementAt(-1+AV117GXV1) ;
                  AV22f = (short)(AV22f+1) ;
                  if ( AV22f > 0 )
                  {
                     AV19errorFormato = "" ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "fila ", "")+GXutil.trim( GXutil.str( AV22f, 4, 0))+" "+GXutil.trim( AV25fileLine)) ;
                     AV87MigrLegCUIL = GXutil.substring( AV25fileLine, 5, 11) ;
                     AV81LegCUIL = GXutil.lval( AV87MigrLegCUIL) ;
                     AV85OsoDescrip = GXutil.substring( AV25fileLine, 40, 6) ;
                     AV92MigrLegModalidad = GXutil.substring( AV25fileLine, 16, 4) ;
                     if ( GXutil.strSearch( AV92MigrLegModalidad, "/", 1) != 0 )
                     {
                        AV92MigrLegModalidad = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV92MigrLegModalidad,"/")).elementAt(-1+1) ;
                     }
                     AV112MigrLegPueAfip = GXutil.substring( AV25fileLine, 85, 4) ;
                     AV89modoLiqPalabra = GXutil.substring( AV25fileLine, 73, 1) ;
                     AV98anioPalabra = GXutil.substring( AV25fileLine, 20, 4) ;
                     AV99mesPalabra = GXutil.substring( AV25fileLine, 25, 2) ;
                     AV100diaPalabra = GXutil.substring( AV25fileLine, 28, 2) ;
                     AV86LegFecIngreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV98anioPalabra, "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV99mesPalabra, "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV100diaPalabra, ".")))) ;
                     AV98anioPalabra = GXutil.substring( AV25fileLine, 30, 4) ;
                     AV99mesPalabra = GXutil.substring( AV25fileLine, 35, 2) ;
                     AV100diaPalabra = GXutil.substring( AV25fileLine, 38, 2) ;
                     AV101LegFecEgreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV98anioPalabra, "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV99mesPalabra, "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV100diaPalabra, ".")))) ;
                     AV90MigrLegConvenio = GXutil.substring( AV25fileLine, 109, 11) ;
                     AV103auxPalabra = GXutil.trim( AV90MigrLegConvenio) ;
                     AV90MigrLegConvenio = "" ;
                     AV107fueraDeConvenioEs = false ;
                     if ( (GXutil.strcmp("", AV103auxPalabra)==0) || ( GXutil.strcmp(AV103auxPalabra, "9999/99") == 0 ) )
                     {
                        AV107fueraDeConvenioEs = true ;
                        GXt_char3 = AV90MigrLegConvenio ;
                        GXv_char4[0] = GXt_char3 ;
                        new web.textofueradeconvenio(remoteHandle, context).execute( AV12CliCod, GXv_char4) ;
                        importarlegajoafiprellab2.this.GXt_char3 = GXv_char4[0] ;
                        AV90MigrLegConvenio = GXt_char3 ;
                     }
                     else
                     {
                        AV102x = (short)(1) ;
                        AV104empezoNro = false ;
                        while ( AV102x <= GXutil.len( AV103auxPalabra) )
                        {
                           AV105char = GXutil.substring( AV103auxPalabra, AV102x, 1) ;
                           if ( GXutil.strcmp(AV105char, "0") != 0 )
                           {
                              AV104empezoNro = true ;
                           }
                           if ( AV104empezoNro )
                           {
                              AV90MigrLegConvenio += AV105char ;
                           }
                           AV102x = (short)(AV102x+1) ;
                        }
                        AV90MigrLegConvenio = GXutil.strReplace( AV90MigrLegConvenio, "151/75", "660/13") ;
                     }
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "convenio ", "")+AV90MigrLegConvenio) ;
                     if ( GXutil.strcmp(AV90MigrLegConvenio, new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)) == 0 )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV91MigrLegCategoria = "" ;
                        AV38ImpLiqDetImp = GXutil.substring( AV25fileLine, 58, 15) ;
                     }
                     else
                     {
                        AV91MigrLegCategoria = GXutil.substring( AV25fileLine, 103, 6) ;
                        AV38ImpLiqDetImp = "" ;
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "setea importe vacio", "")) ;
                     }
                     AV111MigrLegActLabClas = GXutil.substring( AV25fileLine, 79, 6) ;
                     AV10algunoCompleto = true ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "pone algunocompleto en ", "")+GXutil.trim( GXutil.booltostr( AV10algunoCompleto))) ;
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
                        if ( (GXutil.strcmp("", AV85OsoDescrip)==0) )
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
                        if ( (GXutil.strcmp("", AV38ImpLiqDetImp)==0) && ( GXutil.strcmp(AV90MigrLegConvenio, new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
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
                        if ( (GXutil.strcmp("", AV89modoLiqPalabra)==0) || ( CommonUtil.decimalVal( AV89modoLiqPalabra, ".").doubleValue() == 0 ) )
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
                        if ( ( GXutil.strcmp(AV90MigrLegConvenio, new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)) == 0 ) && ! AV107fueraDeConvenioEs )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
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
                        if ( ( GXutil.strcmp(AV90MigrLegConvenio, new web.textofueradeconvenio(remoteHandle, context).executeUdp( AV12CliCod)) != 0 ) && ( (GXutil.strcmp("", AV91MigrLegCategoria)==0) || ( CommonUtil.decimalVal( AV91MigrLegCategoria, ".").doubleValue() == 0 ) ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
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
                        if ( (GXutil.strcmp("", AV92MigrLegModalidad)==0) || ( CommonUtil.decimalVal( AV92MigrLegModalidad, ".").doubleValue() == 0 ) )
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
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "alta &MigrLegCUIL ", "")+AV87MigrLegCUIL+httpContext.getMessage( " &ImpLiqLSDSec ", "")+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0))) ;
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
                  if ( ! AV49IsOk )
                  {
                     if (true) break;
                  }
                  AV117GXV1 = (int)(AV117GXV1+1) ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "queda algunocompleto en ", "")+GXutil.trim( GXutil.booltostr( AV10algunoCompleto))) ;
               if ( ! AV10algunoCompleto )
               {
                  AV19errorFormato = "" ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "fi 9", "")) ;
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
         if ( AV116GXLvl14 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0))) ;
            AV18errores.add(httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV46ImpLiqLSDSec, 4, 0)), 0);
         }
         if ( ! AV49IsOk )
         {
            if (true) break;
         }
         AV68vez = (short)(AV68vez+1) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "isok", "")+GXutil.trim( GXutil.booltostr( AV49IsOk))) ;
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
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "formainv ", "")+AV17error) ;
   }

   public void S121( )
   {
      /* 'ASIGNAR' Routine */
      returnInSub = false ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( true );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegconvenio( GXutil.trim( AV90MigrLegConvenio) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas( GXutil.trim( AV111MigrLegActLabClas) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegpueafip( GXutil.trim( AV112MigrLegPueAfip) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcategoria( GXutil.trim( AV91MigrLegCategoria) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( GXutil.trim( AV92MigrLegModalidad) );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( false );
      AV97que = httpContext.getMessage( "Modalidad", "") ;
      /* Execute user subroutine: 'SACAR WARNING DEFAULT' */
      S131 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(GXutil.trim( AV89modoLiqPalabra), "1") == 0 )
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
         GXt_date5 = GXutil.nullDate() ;
         GXv_date6[0] = GXt_date5 ;
         new web.fecnacpredetimpor(remoteHandle, context).execute( GXv_date6) ;
         importarlegajoafiprellab2.this.GXt_date5 = GXv_date6[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( GXt_date5 );
      }
      if ( (GXutil.strcmp("", AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid())==0) )
      {
         GXv_int7[0] = AV94ultimoId ;
         GXv_char4[0] = AV95LegId ;
         new web.getnextlegajoidsinrepetir(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int7, GXv_char4) ;
         importarlegajoafiprellab2.this.AV94ultimoId = GXv_int7[0] ;
         importarlegajoafiprellab2.this.AV95LegId = GXv_char4[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( AV95LegId );
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "Set record values &importacion_legajo.MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( GXutil.trim( GXutil.str( AV81LegCUIL, 11, 0)) );
      if ( ! (GXutil.strcmp("", AV85OsoDescrip)==0) && ( GXutil.strcmp(GXutil.trim( AV85OsoDescrip), "000000") != 0 ) )
      {
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( GXutil.trim( AV85OsoDescrip) );
      }
      if ( ! (GXutil.strcmp("", AV85OsoDescrip)==0) )
      {
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Obra social", ""), GXv_char4) ;
         importarlegajoafiprellab2.this.GXt_char3 = GXv_char4[0] ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), GXt_char3+httpContext.getMessage( " <BR>", ""), "") );
      }
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV86LegFecIngreso );
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso( AV101LegFecEgreso );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "&ImpLiqDetImp?? ¡ ", "")+GXutil.trim( AV38ImpLiqDetImp)) ;
      if ( ! (GXutil.strcmp("", AV38ImpLiqDetImp)==0) )
      {
         GXv_Sdtimportacion_legajo8[0] = AV48importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo8, AV38ImpLiqDetImp, AV86LegFecIngreso) ;
         AV48importacion_legajo = GXv_Sdtimportacion_legajo8[0] ;
      }
      else
      {
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbanco( "" );
         GXv_Sdtimportacion_legajo8[0] = AV48importacion_legajo;
         new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo8, "", AV86LegFecIngreso) ;
         AV48importacion_legajo = GXv_Sdtimportacion_legajo8[0] ;
      }
   }

   public void S141( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV55MigrLegNumero ;
      new web.getmigrlegporcuil(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV87MigrLegCUIL, GXv_int2) ;
      importarlegajoafiprellab2.this.AV55MigrLegNumero = GXv_int2[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "&MigrLegCUIL ", "")+AV87MigrLegCUIL+httpContext.getMessage( " trae &MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV55MigrLegNumero, 8, 0))) ;
      AV48importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      if ( (0==AV55MigrLegNumero) )
      {
         AV21existe = false ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Clicod( AV12CliCod );
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Empcod( AV16EmpCod );
         GXv_int2[0] = AV55MigrLegNumero ;
         new web.obtieneultimolegajomigracion(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, GXv_int2) ;
         importarlegajoafiprellab2.this.AV55MigrLegNumero = GXv_int2[0] ;
         AV55MigrLegNumero = (int)(AV55MigrLegNumero+1) ;
         AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnumero( AV55MigrLegNumero );
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "existe migrleg", "")) ;
         AV21existe = true ;
         AV48importacion_legajo.Load(AV12CliCod, AV16EmpCod, AV55MigrLegNumero);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "load &importacion_legajo ", "")+GXutil.trim( GXutil.str( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnumero(), 8, 0))+httpContext.getMessage( " &importacion_legajo MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV55MigrLegNumero, 8, 0))) ;
   }

   public void S151( )
   {
      /* 'SAVE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "save &importacion_legajo.MigrLegId ", "")+AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
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
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "save 3", "")) ;
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV115Pgmname, httpContext.getMessage( "save 4", "")) ;
      }
   }

   public void S131( )
   {
      /* 'SACAR WARNING DEFAULT' Routine */
      returnInSub = false ;
      GXt_char3 = AV96mensaje ;
      GXt_char9 = AV96mensaje ;
      GXv_char4[0] = GXt_char9 ;
      new web.defaultmigr(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV97que, GXv_char4) ;
      importarlegajoafiprellab2.this.GXt_char9 = GXv_char4[0] ;
      GXv_char10[0] = GXt_char3 ;
      new web.mensajemigrseingresodefault(remoteHandle, context).execute( AV12CliCod, AV97que, GXt_char9, GXv_char10) ;
      importarlegajoafiprellab2.this.GXt_char3 = GXv_char10[0] ;
      AV96mensaje = GXt_char3 ;
      AV48importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV48importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), AV96mensaje, "") );
   }

   protected void cleanup( )
   {
      this.aP4[0] = importarlegajoafiprellab2.this.AV18errores;
      this.aP5[0] = importarlegajoafiprellab2.this.AV11altas;
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
      AV115Pgmname = "" ;
      AV9ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P027N2_A704ImpLiqLSDSec = new short[1] ;
      P027N2_A88ImpLiqSec = new short[1] ;
      P027N2_A1EmpCod = new short[1] ;
      P027N2_A3CliCod = new int[1] ;
      P027N2_A706ImpLiqLSDFileName = new String[] {""} ;
      P027N2_A707ImpLiqLSDFileType = new String[] {""} ;
      P027N2_A705ImpLiqLSDFile = new String[] {""} ;
      P027N2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      AV24File = new com.genexus.util.GXFile();
      AV67varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25fileLine = "" ;
      AV19errorFormato = "" ;
      AV87MigrLegCUIL = "" ;
      AV85OsoDescrip = "" ;
      AV92MigrLegModalidad = "" ;
      AV112MigrLegPueAfip = "" ;
      AV89modoLiqPalabra = "" ;
      AV98anioPalabra = "" ;
      AV99mesPalabra = "" ;
      AV100diaPalabra = "" ;
      AV86LegFecIngreso = GXutil.nullDate() ;
      AV101LegFecEgreso = GXutil.nullDate() ;
      AV90MigrLegConvenio = "" ;
      AV103auxPalabra = "" ;
      AV105char = "" ;
      AV91MigrLegCategoria = "" ;
      AV38ImpLiqDetImp = "" ;
      AV111MigrLegActLabClas = "" ;
      AV8ultiError = "" ;
      AV17error = "" ;
      AV48importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      AV97que = "" ;
      GXt_date5 = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_int7 = new long[1] ;
      AV95LegId = "" ;
      GXv_Sdtimportacion_legajo8 = new web.Sdtimportacion_legajo[1] ;
      GXv_int2 = new int[1] ;
      AV52Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV96mensaje = "" ;
      GXt_char3 = "" ;
      GXt_char9 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char10 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajoafiprellab2__default(),
         new Object[] {
             new Object[] {
            P027N2_A704ImpLiqLSDSec, P027N2_A88ImpLiqSec, P027N2_A1EmpCod, P027N2_A3CliCod, P027N2_A706ImpLiqLSDFileName, P027N2_A707ImpLiqLSDFileType, P027N2_A705ImpLiqLSDFile, P027N2_A708ImpLiqLSDFileNameAndType
            }
         }
      );
      AV115Pgmname = "ImportarLegajoAfipRelLab2" ;
      /* GeneXus formulas. */
      AV115Pgmname = "ImportarLegajoAfipRelLab2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV116GXLvl14 ;
   private short AV16EmpCod ;
   private short AV47ImpLiqSec ;
   private short AV46ImpLiqLSDSec ;
   private short AV11altas ;
   private short AV68vez ;
   private short A704ImpLiqLSDSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV22f ;
   private short AV102x ;
   private short AV15e ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int GXt_int1 ;
   private int A3CliCod ;
   private int AV117GXV1 ;
   private int AV55MigrLegNumero ;
   private int GXv_int2[] ;
   private long AV94ultimoId ;
   private long AV81LegCUIL ;
   private long GXv_int7[] ;
   private String AV115Pgmname ;
   private String scmdbuf ;
   private String A707ImpLiqLSDFileType ;
   private String AV25fileLine ;
   private String AV87MigrLegCUIL ;
   private String AV89modoLiqPalabra ;
   private String AV98anioPalabra ;
   private String AV99mesPalabra ;
   private String AV100diaPalabra ;
   private String AV103auxPalabra ;
   private String AV105char ;
   private String AV38ImpLiqDetImp ;
   private String AV97que ;
   private String AV95LegId ;
   private String GXt_char3 ;
   private String GXt_char9 ;
   private String GXv_char4[] ;
   private String GXv_char10[] ;
   private java.util.Date AV9ahora ;
   private java.util.Date AV86LegFecIngreso ;
   private java.util.Date AV101LegFecEgreso ;
   private java.util.Date GXt_date5 ;
   private java.util.Date GXv_date6[] ;
   private boolean AV62seguir ;
   private boolean AV49IsOk ;
   private boolean AV13completo ;
   private boolean AV10algunoCompleto ;
   private boolean AV107fueraDeConvenioEs ;
   private boolean AV104empezoNro ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private boolean AV21existe ;
   private String A705ImpLiqLSDFile ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String AV19errorFormato ;
   private String AV85OsoDescrip ;
   private String AV92MigrLegModalidad ;
   private String AV112MigrLegPueAfip ;
   private String AV90MigrLegConvenio ;
   private String AV91MigrLegCategoria ;
   private String AV111MigrLegActLabClas ;
   private String AV8ultiError ;
   private String AV17error ;
   private String AV96mensaje ;
   private com.genexus.util.GXFile AV24File ;
   private web.Sdtimportacion_legajo AV48importacion_legajo ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P027N2_A704ImpLiqLSDSec ;
   private short[] P027N2_A88ImpLiqSec ;
   private short[] P027N2_A1EmpCod ;
   private int[] P027N2_A3CliCod ;
   private String[] P027N2_A706ImpLiqLSDFileName ;
   private String[] P027N2_A707ImpLiqLSDFileType ;
   private String[] P027N2_A705ImpLiqLSDFile ;
   private String[] P027N2_A708ImpLiqLSDFileNameAndType ;
   private GXSimpleCollection<String> AV67varcharcollection ;
   private GXSimpleCollection<String> AV18errores ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV52Messages ;
   private web.Sdtimportacion_legajo GXv_Sdtimportacion_legajo8[] ;
}

final  class importarlegajoafiprellab2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027N2", "SELECT ImpLiqLSDSec, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDFileName, ImpLiqLSDFileType, ImpLiqLSDFile, ImpLiqLSDFileNameAndType FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

