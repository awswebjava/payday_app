package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajoafipdatcomp extends GXProcedure
{
   public importarlegajoafipdatcomp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajoafipdatcomp.class ), "" );
   }

   public importarlegajoafipdatcomp( int remoteHandle ,
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
      importarlegajoafipdatcomp.this.aP5 = new short[] {0};
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
      importarlegajoafipdatcomp.this.AV13CliCod = aP0;
      importarlegajoafipdatcomp.this.AV17EmpCod = aP1;
      importarlegajoafipdatcomp.this.AV48ImpLiqSec = aP2;
      importarlegajoafipdatcomp.this.AV47ImpLiqLSDSec = aP3;
      importarlegajoafipdatcomp.this.aP4 = aP4;
      importarlegajoafipdatcomp.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, "1") ;
      AV69vez = (short)(1) ;
      AV63seguir = true ;
      AV50IsOk = true ;
      GXt_int1 = (int)(AV93ultimoId) ;
      GXv_int2[0] = GXt_int1 ;
      new web.obtienesiguientelegajo(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_int2) ;
      importarlegajoafipdatcomp.this.GXt_int1 = GXv_int2[0] ;
      AV93ultimoId = GXt_int1 ;
      while ( ( AV69vez <= 2 ) && ( AV63seguir ) )
      {
         if ( AV19errores.size() > 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            if (true) break;
         }
         AV19errores.clear();
         AV10ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV104GXLvl14 = (byte)(0) ;
         /* Using cursor P027P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV17EmpCod), Short.valueOf(AV48ImpLiqSec), Short.valueOf(AV47ImpLiqLSDSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A704ImpLiqLSDSec = P027P2_A704ImpLiqLSDSec[0] ;
            A88ImpLiqSec = P027P2_A88ImpLiqSec[0] ;
            A1EmpCod = P027P2_A1EmpCod[0] ;
            A3CliCod = P027P2_A3CliCod[0] ;
            A706ImpLiqLSDFileName = P027P2_A706ImpLiqLSDFileName[0] ;
            A707ImpLiqLSDFileType = P027P2_A707ImpLiqLSDFileType[0] ;
            A705ImpLiqLSDFile = P027P2_A705ImpLiqLSDFile[0] ;
            A708ImpLiqLSDFileNameAndType = P027P2_A708ImpLiqLSDFileNameAndType[0] ;
            AV104GXLvl14 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, "2") ;
            AV25File.setSource( A705ImpLiqLSDFile );
            if ( AV25File.exists() )
            {
               AV23f = (short)(0) ;
               AV68varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV25File.readAllLines()) ;
               AV14completo = false ;
               AV11algunoCompleto = false ;
               AV105GXV1 = 1 ;
               while ( AV105GXV1 <= AV68varcharcollection.size() )
               {
                  AV26fileLine = (String)AV68varcharcollection.elementAt(-1+AV105GXV1) ;
                  AV23f = (short)(AV23f+1) ;
                  if ( ( AV23f == 1 ) && ( GXutil.strcmp(GXutil.trim( AV26fileLine), httpContext.getMessage( "CUIL        APELLIDO Y NOMBRE                       TIPO DOC.                     NUMERO DOC.     SEXO NACIONALIDAD        FECHA NAC.  FECHA FALL. DOMICILIO.                                                  CBU O BOCA DE PAGO     FORMACION                               DISCAPACIDAD TELEFONO                                                                                            EMAIL                                                                                               ", "")) != 0 ) )
                  {
                     AV20errorFormato = httpContext.getMessage( "No coincide la primera línea con el formato esperado", "") ;
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
                     if ( AV23f > 1 )
                     {
                        AV20errorFormato = "" ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "fila ", "")+GXutil.trim( GXutil.str( AV23f, 4, 0))+" "+GXutil.trim( AV26fileLine)) ;
                        AV88MigrLegCUIL = GXutil.substring( AV26fileLine, 1, 11) ;
                        AV82LegCUIL = GXutil.lval( AV88MigrLegCUIL) ;
                        AV83LegNomApe = GXutil.substring( AV26fileLine, 13, 40) ;
                        GXv_char3[0] = AV84LegNombre ;
                        GXv_char4[0] = AV85LegApellido ;
                        new web.desglosarnombreyapellido(remoteHandle, context).execute( AV83LegNomApe, GXv_char3, GXv_char4) ;
                        importarlegajoafipdatcomp.this.AV84LegNombre = GXv_char3[0] ;
                        importarlegajoafipdatcomp.this.AV85LegApellido = GXv_char4[0] ;
                        AV94MigrLegSexo = GXutil.substring( AV26fileLine, 99, 1) ;
                        AV96fechaNacStr = GXutil.substring( AV26fileLine, 124, 10) ;
                        AV95MigrLegFecNac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV96fechaNacStr, 7, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV96fechaNacStr, 4, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV96fechaNacStr, 1, 2), ".")))) ;
                        AV98MigrLegEmail = GXutil.substring( AV26fileLine, 384, 100) ;
                        AV99MigrLegDomici = GXutil.substring( AV26fileLine, 148, 60) ;
                        AV100MigrLegTelefono = GXutil.substring( AV26fileLine, 284, 100) ;
                        AV11algunoCompleto = true ;
                        if ( AV69vez == 1 )
                        {
                           if ( (0==AV82LegCUIL) )
                           {
                              AV20errorFormato = httpContext.getMessage( "No se encontró CUIL \"", "") + AV88MigrLegCUIL + "\" (" + GXutil.str( AV82LegCUIL, 11, 0) + ")" ;
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
                           if ( (GXutil.strcmp("", AV83LegNomApe)==0) || ( CommonUtil.decimalVal( AV83LegNomApe, ".").doubleValue() > 0 ) )
                           {
                              AV20errorFormato = httpContext.getMessage( "No se encontró dato de nombre y apellido en txt", "") ;
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
                           if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV95MigrLegFecNac)) )
                           {
                              AV20errorFormato = httpContext.getMessage( "No se encontró dato de fecha de nacimiento", "") ;
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
                           if ( (GXutil.strcmp("", AV94MigrLegSexo)==0) )
                           {
                              AV20errorFormato = httpContext.getMessage( "No se encontró dato de sexo", "") ;
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
                           new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "alta &MigrLegCUIL ", "")+AV88MigrLegCUIL+httpContext.getMessage( " &ImpLiqLSDSec ", "")+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0))) ;
                           /* Execute user subroutine: 'LOAD KEY' */
                           S131 ();
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
                           S141 ();
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
                  if ( ! AV50IsOk )
                  {
                     if (true) break;
                  }
                  AV105GXV1 = (int)(AV105GXV1+1) ;
               }
               if ( ! AV11algunoCompleto )
               {
                  AV20errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "fi 9", "")) ;
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
               AV25File.close();
            }
            else
            {
               AV19errores.add(httpContext.getMessage( "No se pudo abrir el archivo ", "")+GXutil.trim( A708ImpLiqLSDFileNameAndType), 0);
            }
            if ( ( AV19errores.size() == 0 ) && ( AV69vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV19errores.size() > 0 ) && ( AV69vez == 1 ) )
               {
                  AV63seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV104GXLvl14 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV17EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV48ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0))) ;
            AV19errores.add(httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV17EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV48ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV47ImpLiqLSDSec, 4, 0)), 0);
         }
         if ( ! AV50IsOk )
         {
            if (true) break;
         }
         AV69vez = (short)(AV69vez+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "isok", "")+GXutil.trim( GXutil.booltostr( AV50IsOk))) ;
      if ( AV19errores.size() > 0 )
      {
         AV16e = (short)(1) ;
         AV19errores.sort("");
         while ( AV16e <= AV19errores.size() )
         {
            if ( GXutil.strcmp((String)AV19errores.elementAt(-1+AV16e), AV9ultiError) == 0 )
            {
               AV19errores.removeItem(AV16e);
            }
            else
            {
               AV9ultiError = (String)AV19errores.elementAt(-1+AV16e) ;
               AV16e = (short)(AV16e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV50IsOk = false ;
      AV18error = httpContext.getMessage( "Archivo con formato inválido ", "") ;
      if ( ! (GXutil.strcmp("", AV20errorFormato)==0) )
      {
         AV18error += "(" + GXutil.trim( AV20errorFormato) + ")" ;
      }
      AV19errores.add(AV18error, 0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "formainv ", "")+AV18error) ;
   }

   public void S121( )
   {
      /* 'ASIGNAR' Routine */
      returnInSub = false ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( true );
      if ( (GXutil.strcmp("", AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid())==0) )
      {
         GXv_int5[0] = AV93ultimoId ;
         GXv_char4[0] = AV97LegId ;
         new web.getnextlegajoidsinrepetir(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_int5, GXv_char4) ;
         importarlegajoafipdatcomp.this.AV93ultimoId = GXv_int5[0] ;
         importarlegajoafipdatcomp.this.AV97LegId = GXv_char4[0] ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( GXutil.trim( AV97LegId) );
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "Set record values &importacion_legajo.MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( GXutil.trim( GXutil.str( AV82LegCUIL, 11, 0)) );
      if ( ! (GXutil.strcmp("", AV84LegNombre)==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXutil.trim( AV84LegNombre) );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegerrores( GXutil.strReplace( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegerrores(), httpContext.getMessage( "Nombres es requerido. <BR>", ""), "") );
      }
      if ( ! (GXutil.strcmp("", AV85LegApellido)==0) )
      {
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXutil.trim( AV85LegApellido) );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegerrores( GXutil.strReplace( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegerrores(), httpContext.getMessage( "Apellido es requerido. <BR>", ""), "") );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegsexo( AV94MigrLegSexo );
      if ( ! (GXutil.strcmp("", AV94MigrLegSexo)==0) )
      {
         GXt_char6 = "" ;
         GXv_char4[0] = GXt_char6 ;
         new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Género", ""), GXv_char4) ;
         importarlegajoafipdatcomp.this.GXt_char6 = GXv_char4[0] ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), GXt_char6+httpContext.getMessage( " <BR>", ""), "") );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( AV95MigrLegFecNac );
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV95MigrLegFecNac)) )
      {
         GXt_char6 = "" ;
         GXv_char4[0] = GXt_char6 ;
         new web.warningmigrfaltadato(remoteHandle, context).execute( httpContext.getMessage( "Fecha de nacimiento", ""), GXv_char4) ;
         importarlegajoafipdatcomp.this.GXt_char6 = GXv_char4[0] ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( GXutil.strReplace( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegwarnings(), GXt_char6+httpContext.getMessage( " <BR>", ""), "") );
      }
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegemail( GXutil.trim( AV98MigrLegEmail) );
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegdomici( GXutil.trim( AV99MigrLegDomici) );
      AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtelefono( GXutil.trim( AV100MigrLegTelefono) );
      GXv_Sdtimportacion_legajo7[0] = AV49importacion_legajo;
      new web.asignarmigrsueldosbc(remoteHandle, context).execute( GXv_Sdtimportacion_legajo7, "", AV77fecha) ;
      AV49importacion_legajo = GXv_Sdtimportacion_legajo7[0] ;
   }

   public void S131( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV56MigrLegNumero ;
      new web.getmigrlegporcuil(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV88MigrLegCUIL, GXv_int2) ;
      importarlegajoafipdatcomp.this.AV56MigrLegNumero = GXv_int2[0] ;
      AV49importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      if ( (0==AV56MigrLegNumero) )
      {
         AV22existe = false ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Clicod( AV13CliCod );
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Empcod( AV17EmpCod );
         GXv_int2[0] = AV56MigrLegNumero ;
         new web.obtieneultimolegajomigracion(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_int2) ;
         importarlegajoafipdatcomp.this.AV56MigrLegNumero = GXv_int2[0] ;
         AV56MigrLegNumero = (int)(AV56MigrLegNumero+1) ;
         AV49importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnumero( AV56MigrLegNumero );
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "existe migrleg", "")) ;
         AV22existe = true ;
         AV49importacion_legajo.Load(AV13CliCod, AV17EmpCod, AV56MigrLegNumero);
         new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "load &importacion_legajo ", "")+GXutil.trim( GXutil.str( AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnumero(), 8, 0))+httpContext.getMessage( " &importacion_legajo MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV56MigrLegNumero, 8, 0))) ;
   }

   public void S141( )
   {
      /* 'SAVE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "save &importacion_legajo.MigrLegId ", "")+AV49importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid()) ;
      if ( ! AV22existe )
      {
         AV49importacion_legajo.Save();
      }
      else
      {
         AV49importacion_legajo.Update();
      }
      if ( ! AV49importacion_legajo.Success() )
      {
         AV53Messages = AV49importacion_legajo.GetMessages() ;
         AV50IsOk = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "save 3", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV103Pgmname, httpContext.getMessage( "save 4", "")) ;
      }
   }

   protected void cleanup( )
   {
      this.aP4[0] = importarlegajoafipdatcomp.this.AV19errores;
      this.aP5[0] = importarlegajoafipdatcomp.this.AV12altas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV103Pgmname = "" ;
      AV10ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P027P2_A704ImpLiqLSDSec = new short[1] ;
      P027P2_A88ImpLiqSec = new short[1] ;
      P027P2_A1EmpCod = new short[1] ;
      P027P2_A3CliCod = new int[1] ;
      P027P2_A706ImpLiqLSDFileName = new String[] {""} ;
      P027P2_A707ImpLiqLSDFileType = new String[] {""} ;
      P027P2_A705ImpLiqLSDFile = new String[] {""} ;
      P027P2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      AV25File = new com.genexus.util.GXFile();
      AV68varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26fileLine = "" ;
      AV20errorFormato = "" ;
      AV88MigrLegCUIL = "" ;
      AV83LegNomApe = "" ;
      AV84LegNombre = "" ;
      GXv_char3 = new String[1] ;
      AV85LegApellido = "" ;
      AV94MigrLegSexo = "" ;
      AV96fechaNacStr = "" ;
      AV95MigrLegFecNac = GXutil.nullDate() ;
      AV98MigrLegEmail = "" ;
      AV99MigrLegDomici = "" ;
      AV100MigrLegTelefono = "" ;
      AV9ultiError = "" ;
      AV18error = "" ;
      AV49importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      GXv_int5 = new long[1] ;
      AV97LegId = "" ;
      GXt_char6 = "" ;
      GXv_char4 = new String[1] ;
      GXv_Sdtimportacion_legajo7 = new web.Sdtimportacion_legajo[1] ;
      AV77fecha = GXutil.nullDate() ;
      GXv_int2 = new int[1] ;
      AV53Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajoafipdatcomp__default(),
         new Object[] {
             new Object[] {
            P027P2_A704ImpLiqLSDSec, P027P2_A88ImpLiqSec, P027P2_A1EmpCod, P027P2_A3CliCod, P027P2_A706ImpLiqLSDFileName, P027P2_A707ImpLiqLSDFileType, P027P2_A705ImpLiqLSDFile, P027P2_A708ImpLiqLSDFileNameAndType
            }
         }
      );
      AV103Pgmname = "ImportarLegajoAfipDatComp" ;
      /* GeneXus formulas. */
      AV103Pgmname = "ImportarLegajoAfipDatComp" ;
      Gx_err = (short)(0) ;
   }

   private byte AV104GXLvl14 ;
   private short AV17EmpCod ;
   private short AV48ImpLiqSec ;
   private short AV47ImpLiqLSDSec ;
   private short AV12altas ;
   private short AV69vez ;
   private short A704ImpLiqLSDSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV23f ;
   private short AV16e ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int A3CliCod ;
   private int AV105GXV1 ;
   private int AV56MigrLegNumero ;
   private int GXv_int2[] ;
   private long AV93ultimoId ;
   private long AV82LegCUIL ;
   private long GXv_int5[] ;
   private String AV103Pgmname ;
   private String scmdbuf ;
   private String A707ImpLiqLSDFileType ;
   private String AV26fileLine ;
   private String AV88MigrLegCUIL ;
   private String GXv_char3[] ;
   private String AV94MigrLegSexo ;
   private String AV96fechaNacStr ;
   private String AV97LegId ;
   private String GXt_char6 ;
   private String GXv_char4[] ;
   private java.util.Date AV10ahora ;
   private java.util.Date AV95MigrLegFecNac ;
   private java.util.Date AV77fecha ;
   private boolean AV63seguir ;
   private boolean AV50IsOk ;
   private boolean Cond_result ;
   private boolean AV14completo ;
   private boolean AV11algunoCompleto ;
   private boolean returnInSub ;
   private boolean AV22existe ;
   private String A705ImpLiqLSDFile ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String AV20errorFormato ;
   private String AV83LegNomApe ;
   private String AV84LegNombre ;
   private String AV85LegApellido ;
   private String AV98MigrLegEmail ;
   private String AV99MigrLegDomici ;
   private String AV100MigrLegTelefono ;
   private String AV9ultiError ;
   private String AV18error ;
   private com.genexus.util.GXFile AV25File ;
   private web.Sdtimportacion_legajo AV49importacion_legajo ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P027P2_A704ImpLiqLSDSec ;
   private short[] P027P2_A88ImpLiqSec ;
   private short[] P027P2_A1EmpCod ;
   private int[] P027P2_A3CliCod ;
   private String[] P027P2_A706ImpLiqLSDFileName ;
   private String[] P027P2_A707ImpLiqLSDFileType ;
   private String[] P027P2_A705ImpLiqLSDFile ;
   private String[] P027P2_A708ImpLiqLSDFileNameAndType ;
   private GXSimpleCollection<String> AV68varcharcollection ;
   private GXSimpleCollection<String> AV19errores ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV53Messages ;
   private web.Sdtimportacion_legajo GXv_Sdtimportacion_legajo7[] ;
}

final  class importarlegajoafipdatcomp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027P2", "SELECT ImpLiqLSDSec, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDFileName, ImpLiqLSDFileType, ImpLiqLSDFile, ImpLiqLSDFileNameAndType FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

