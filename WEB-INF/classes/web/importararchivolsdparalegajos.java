package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importararchivolsdparalegajos extends GXProcedure
{
   public importararchivolsdparalegajos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importararchivolsdparalegajos.class ), "" );
   }

   public importararchivolsdparalegajos( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 )
   {
      importararchivolsdparalegajos.this.AV12CliCod = aP0;
      importararchivolsdparalegajos.this.AV14EmpCod = aP1;
      importararchivolsdparalegajos.this.AV22ImpLiqSec = aP2;
      importararchivolsdparalegajos.this.AV30path = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV29OK = true ;
      AV39GXLvl5 = (byte)(0) ;
      /* Using cursor P027M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV14EmpCod), Short.valueOf(AV22ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A88ImpLiqSec = P027M2_A88ImpLiqSec[0] ;
         A1EmpCod = P027M2_A1EmpCod[0] ;
         A3CliCod = P027M2_A3CliCod[0] ;
         AV39GXLvl5 = (byte)(1) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV39GXLvl5 == 0 )
      {
         /*
            INSERT RECORD ON TABLE importacion_liquidacion

         */
         A3CliCod = AV12CliCod ;
         A1EmpCod = AV14EmpCod ;
         A88ImpLiqSec = AV22ImpLiqSec ;
         A636ImpLiqFec = GXutil.serverNow( context, remoteHandle, pr_default) ;
         A637ImpLiqConFile = "" ;
         A638ImpLiqConFileName = "" ;
         A639ImpLiqConFileType = "" ;
         A658ImpLiqConFileNameAndType = "" ;
         /* Using cursor P027M3 */
         A638ImpLiqConFileName = com.genexus.util.GXFile.getgxFilename( A637ImpLiqConFile) ;
         A639ImpLiqConFileType = com.genexus.util.GXFile.getgxFileext( A637ImpLiqConFile) ;
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A636ImpLiqFec, A637ImpLiqConFile, A638ImpLiqConFileName, A639ImpLiqConFileType, A658ImpLiqConFileNameAndType});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion");
         if ( (pr_default.getStatus(1) == 1) )
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
      /* Using cursor P027M4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV14EmpCod), Short.valueOf(AV22ImpLiqSec)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = P027M4_A3CliCod[0] ;
         A1EmpCod = P027M4_A1EmpCod[0] ;
         A88ImpLiqSec = P027M4_A88ImpLiqSec[0] ;
         A704ImpLiqLSDSec = P027M4_A704ImpLiqLSDSec[0] ;
         AV21ImpLiqLSDSec = A704ImpLiqLSDSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      AV21ImpLiqLSDSec = (short)(AV21ImpLiqLSDSec+1) ;
      AV18File.setSource( AV30path );
      AV20ImpLiqLSDFile = AV18File.getURI() ;
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod( AV12CliCod );
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod( AV14EmpCod );
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( AV22ImpLiqSec );
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( AV21ImpLiqLSDSec );
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( AV20ImpLiqLSDFile );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&&File.GetURI() ", "")+GXutil.trim( AV18File.getURI())) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&path ", "")+GXutil.trim( AV30path)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "!&ImpLiqLSDFile ", "")+GXutil.trim( AV20ImpLiqLSDFile)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&&&EmpCod ", "")+GXutil.trim( GXutil.str( AV14EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&&&ImpLiqSec ", "")+GXutil.trim( GXutil.str( AV22ImpLiqSec, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&&&&&ImpLiqLSDSec ", "")+GXutil.trim( GXutil.str( AV21ImpLiqLSDSec, 4, 0))) ;
      AV24importacion_liquidacion_lsd.Save();
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "save 1 ", "")) ;
      if ( AV24importacion_liquidacion_lsd.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "success", "")) ;
         GXv_objcol_svchar1[0] = AV15errores ;
         GXv_int2[0] = AV10altas ;
         new web.importarlegajolsd(remoteHandle, context).execute( AV12CliCod, AV14EmpCod, AV22ImpLiqSec, AV21ImpLiqLSDSec, GXv_objcol_svchar1, GXv_int2) ;
         AV15errores = GXv_objcol_svchar1[0] ;
         importararchivolsdparalegajos.this.AV10altas = GXv_int2[0] ;
         Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&\"errores ", "")+GXutil.trim( GXutil.str( AV15errores.size(), 9, 0))) ;
         if ( AV15errores.size() == 0 )
         {
            /* Execute user subroutine: 'ACTUALIZAR SUELDO' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'DAR OK' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            GXv_objcol_svchar1[0] = AV36errores1 ;
            GXv_int2[0] = (short)(0) ;
            new web.importarlegajoafiprellab2(remoteHandle, context).execute( AV12CliCod, AV14EmpCod, AV22ImpLiqSec, AV21ImpLiqLSDSec, GXv_objcol_svchar1, GXv_int2) ;
            AV36errores1 = GXv_objcol_svchar1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&errores1 ", "")+AV36errores1.toJSonString(false)) ;
            if ( AV36errores1.size() == 0 )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
               /* Execute user subroutine: 'ACTUALIZAR SUELDO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Execute user subroutine: 'DAR OK' */
               S141 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               GXv_objcol_svchar1[0] = AV16errores2 ;
               GXv_int2[0] = (short)(0) ;
               new web.importarlegajoafiprellab(remoteHandle, context).execute( AV12CliCod, AV14EmpCod, AV22ImpLiqSec, AV21ImpLiqLSDSec, GXv_objcol_svchar1, GXv_int2) ;
               AV16errores2 = GXv_objcol_svchar1[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&errores2 ", "")+AV16errores2.toJSonString(false)) ;
               if ( AV16errores2.size() == 0 )
               {
                  Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
                  /* Execute user subroutine: 'ACTUALIZAR SUELDO' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  /* Execute user subroutine: 'DAR OK' */
                  S141 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "llama a datcomp", "")) ;
                  GXv_objcol_svchar1[0] = AV35errores3 ;
                  GXv_int2[0] = (short)(0) ;
                  new web.importarlegajoafipdatcomp(remoteHandle, context).execute( AV12CliCod, AV14EmpCod, AV22ImpLiqSec, AV21ImpLiqLSDSec, GXv_objcol_svchar1, GXv_int2) ;
                  AV35errores3 = GXv_objcol_svchar1[0] ;
                  if ( AV35errores3.size() == 0 )
                  {
                     Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
                     /* Execute user subroutine: 'DAR OK' */
                     S141 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  else
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "errores 3 ", "")+AV35errores3.toJSonString(false)) ;
                     if ( GXutil.strSearch( AV35errores3.toJSonString(false), httpContext.getMessage( "No coincide la primera línea con el formato esperado", ""), 1) != 0 )
                     {
                        if ( ( GXutil.strSearch( AV16errores2.toJSonString(false), httpContext.getMessage( "No coincide la primera línea con el formato esperado", ""), 1) != 0 ) && ( AV36errores1.size() == 0 ) )
                        {
                           new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "da error primera linea errores ", "")+AV15errores.toJSonString(false)) ;
                           /* Execute user subroutine: 'DAR ERROR' */
                           S131 ();
                           if ( returnInSub )
                           {
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                        else
                        {
                           AV15errores.clear();
                           if ( AV36errores1.size() > 0 )
                           {
                              AV15errores.fromJSonString(AV36errores1.toJSonString(false), null);
                              new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "da error &errores1 primera linea", "")) ;
                           }
                           else
                           {
                              AV15errores.fromJSonString(AV16errores2.toJSonString(false), null);
                              new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "da error &errores2 primera linea", "")) ;
                           }
                           /* Execute user subroutine: 'DAR ERROR' */
                           S131 ();
                           if ( returnInSub )
                           {
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                     }
                     else
                     {
                        AV15errores.clear();
                        AV15errores.fromJSonString(AV35errores3.toJSonString(false), null);
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "da error &errores3 primeralinea", "")) ;
                        /* Execute user subroutine: 'DAR ERROR' */
                        S131 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
               }
            }
         }
      }
      else
      {
         AV26Messages = AV24importacion_liquidacion_lsd.GetMessages() ;
         AV29OK = false ;
         /* Execute user subroutine: 'ERRORES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ERRORES' Routine */
      returnInSub = false ;
      AV8error = httpContext.getMessage( "IMPORTARLEGAJO_EXCEL Error ", "") ;
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV26Messages.size() )
      {
         AV25Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV26Messages.elementAt(-1+AV42GXV1));
         AV8error += GXutil.trim( AV25Message.getgxTv_SdtMessages_Message_Description()) + ". " ;
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "ERROR ", "")+AV8error) ;
      AV28NotificationInfo.setgxTv_SdtNotificationInfo_Id( AV8error );
      AV28NotificationInfo.setgxTv_SdtNotificationInfo_Message( httpContext.getMessage( "Error", "") );
      AV32ServerSocket.notify(AV28NotificationInfo);
   }

   public void S121( )
   {
      /* 'ACTUALIZAR SUELDO' Routine */
      returnInSub = false ;
      AV9actualizoBasico = false ;
      /* Using cursor P027M5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV14EmpCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A1EmpCod = P027M5_A1EmpCod[0] ;
         A3CliCod = P027M5_A3CliCod[0] ;
         A2189MigrSueldos = P027M5_A2189MigrSueldos[0] ;
         A608MigrLegBasico = P027M5_A608MigrLegBasico[0] ;
         A597MigrLegCUIL = P027M5_A597MigrLegCUIL[0] ;
         A87MigrLegNumero = P027M5_A87MigrLegNumero[0] ;
         AV27migracion_sueldos.clear();
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "cuil ", "")+A597MigrLegCUIL+httpContext.getMessage( " MigrLegBasico ", "")+GXutil.trim( GXutil.str( A608MigrLegBasico, 14, 2))+httpContext.getMessage( " MigrSueldos ", "")+A2189MigrSueldos) ;
         AV27migracion_sueldos.fromJSonString(A2189MigrSueldos, null);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "&migracion_sueldos count ", "")+GXutil.trim( GXutil.str( AV27migracion_sueldos.size(), 9, 0))) ;
         if ( AV27migracion_sueldos.size() > 0 )
         {
            AV27migracion_sueldos.sort(httpContext.getMessage( "(fecha),(sueldo)", ""));
            A608MigrLegBasico = ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV27migracion_sueldos.elementAt(-1+1)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo() ;
            AV9actualizoBasico = true ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV41Pgmname, httpContext.getMessage( "asigna ", "")+GXutil.trim( GXutil.str( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV27migracion_sueldos.elementAt(-1+1)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo(), 14, 2))) ;
         }
         /* Using cursor P027M6 */
         pr_default.execute(4, new Object[] {A608MigrLegBasico, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV9actualizoBasico )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importararchivolsdparalegajos");
      }
   }

   public void S131( )
   {
      /* 'DAR ERROR' Routine */
      returnInSub = false ;
      AV29OK = false ;
      AV13e = (short)(1) ;
      while ( AV13e <= AV15errores.size() )
      {
         AV25Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV25Message.setgxTv_SdtMessages_Message_Description( (String)AV15errores.elementAt(-1+AV13e) );
         AV25Message.setgxTv_SdtMessages_Message_Id( GXutil.trim( GXutil.str( AV13e, 4, 0)) );
         AV25Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV26Messages.add(AV25Message, 0);
         AV13e = (short)(AV13e+1) ;
      }
      /* Execute user subroutine: 'ERRORES' */
      S111 ();
      if (returnInSub) return;
      AV24importacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( "" );
   }

   public void S141( )
   {
      /* 'DAR OK' Routine */
      returnInSub = false ;
      AV28NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "IMPORTARLEGAJO_EXCEL OK", "") );
      AV28NotificationInfo.setgxTv_SdtNotificationInfo_Message( httpContext.getMessage( "OK", "") );
      AV32ServerSocket.notify(AV28NotificationInfo);
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P027M2_A88ImpLiqSec = new short[1] ;
      P027M2_A1EmpCod = new short[1] ;
      P027M2_A3CliCod = new int[1] ;
      A636ImpLiqFec = GXutil.resetTime( GXutil.nullDate() );
      A637ImpLiqConFile = "" ;
      A638ImpLiqConFileName = "" ;
      A639ImpLiqConFileType = "" ;
      A658ImpLiqConFileNameAndType = "" ;
      Gx_emsg = "" ;
      P027M4_A3CliCod = new int[1] ;
      P027M4_A1EmpCod = new short[1] ;
      P027M4_A88ImpLiqSec = new short[1] ;
      P027M4_A704ImpLiqLSDSec = new short[1] ;
      AV18File = new com.genexus.util.GXFile();
      AV20ImpLiqLSDFile = "" ;
      AV24importacion_liquidacion_lsd = new web.Sdtimportacion_liquidacion_lsd(remoteHandle);
      AV41Pgmname = "" ;
      AV15errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36errores1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16errores2 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35errores3 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar1 = new GXSimpleCollection[1] ;
      GXv_int2 = new short[1] ;
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV8error = "" ;
      AV25Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV28NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV32ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      P027M5_A1EmpCod = new short[1] ;
      P027M5_A3CliCod = new int[1] ;
      P027M5_A2189MigrSueldos = new String[] {""} ;
      P027M5_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P027M5_A597MigrLegCUIL = new String[] {""} ;
      P027M5_A87MigrLegNumero = new int[1] ;
      A2189MigrSueldos = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      A597MigrLegCUIL = "" ;
      AV27migracion_sueldos = new GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem>(web.Sdtmigracion_sueldos_migracion_sueldosItem.class, "migracion_sueldosItem", "PayDay", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importararchivolsdparalegajos__default(),
         new Object[] {
             new Object[] {
            P027M2_A88ImpLiqSec, P027M2_A1EmpCod, P027M2_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            P027M4_A3CliCod, P027M4_A1EmpCod, P027M4_A88ImpLiqSec, P027M4_A704ImpLiqLSDSec
            }
            , new Object[] {
            P027M5_A1EmpCod, P027M5_A3CliCod, P027M5_A2189MigrSueldos, P027M5_A608MigrLegBasico, P027M5_A597MigrLegCUIL, P027M5_A87MigrLegNumero
            }
            , new Object[] {
            }
         }
      );
      AV41Pgmname = "importarArchivoLSDParaLegajos" ;
      /* GeneXus formulas. */
      AV41Pgmname = "importarArchivoLSDParaLegajos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV39GXLvl5 ;
   private short AV14EmpCod ;
   private short AV22ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private short A704ImpLiqLSDSec ;
   private short AV21ImpLiqLSDSec ;
   private short AV10altas ;
   private short GXv_int2[] ;
   private short AV13e ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private int GX_INS76 ;
   private int AV42GXV1 ;
   private int A87MigrLegNumero ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private String scmdbuf ;
   private String A639ImpLiqConFileType ;
   private String Gx_emsg ;
   private String AV41Pgmname ;
   private String A597MigrLegCUIL ;
   private java.util.Date A636ImpLiqFec ;
   private boolean AV29OK ;
   private boolean returnInSub ;
   private boolean AV9actualizoBasico ;
   private String A2189MigrSueldos ;
   private String A637ImpLiqConFile ;
   private String AV20ImpLiqLSDFile ;
   private String AV30path ;
   private String A638ImpLiqConFileName ;
   private String A658ImpLiqConFileNameAndType ;
   private String AV8error ;
   private com.genexus.util.GXFile AV18File ;
   private web.Sdtimportacion_liquidacion_lsd AV24importacion_liquidacion_lsd ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV28NotificationInfo ;
   private IDataStoreProvider pr_default ;
   private short[] P027M2_A88ImpLiqSec ;
   private short[] P027M2_A1EmpCod ;
   private int[] P027M2_A3CliCod ;
   private int[] P027M4_A3CliCod ;
   private short[] P027M4_A1EmpCod ;
   private short[] P027M4_A88ImpLiqSec ;
   private short[] P027M4_A704ImpLiqLSDSec ;
   private short[] P027M5_A1EmpCod ;
   private int[] P027M5_A3CliCod ;
   private String[] P027M5_A2189MigrSueldos ;
   private java.math.BigDecimal[] P027M5_A608MigrLegBasico ;
   private String[] P027M5_A597MigrLegCUIL ;
   private int[] P027M5_A87MigrLegNumero ;
   private GXSimpleCollection<String> AV15errores ;
   private GXSimpleCollection<String> AV36errores1 ;
   private GXSimpleCollection<String> AV16errores2 ;
   private GXSimpleCollection<String> AV35errores3 ;
   private GXSimpleCollection<String> GXv_objcol_svchar1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV26Messages ;
   private GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem> AV27migracion_sueldos ;
   private com.genexus.SdtMessages_Message AV25Message ;
   private com.genexuscore.genexus.server.SdtSocket AV32ServerSocket ;
}

final  class importararchivolsdparalegajos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027M2", "SELECT ImpLiqSec, EmpCod, CliCod FROM importacion_liquidacion WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P027M3", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion(CliCod, EmpCod, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileName, ImpLiqConFileType, ImpLiqConFileNameAndType) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P027M4", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P027M5", "SELECT EmpCod, CliCod, MigrSueldos, MigrLegBasico, MigrLegCUIL, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod  FOR UPDATE OF importacion_legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P027M6", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegBasico=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 13);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               stmt.setBLOBFile(5, (String)parms[4]);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

