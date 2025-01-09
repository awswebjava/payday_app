package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importartodoslsd_test2 extends GXProcedure
{
   public importartodoslsd_test2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importartodoslsd_test2.class ), "" );
   }

   public importartodoslsd_test2( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        short aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             short aP4 )
   {
      importartodoslsd_test2.this.AV10CliCod = aP0;
      importartodoslsd_test2.this.AV11EmpCod = aP1;
      importartodoslsd_test2.this.AV12ImpLiqSec = aP2;
      importartodoslsd_test2.this.AV13que = aP3;
      importartodoslsd_test2.this.AV20mesNro = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LEGAJOS", "")) == 0 )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\2024-06-27_afip_datos complementarios", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV8Path = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\2024-06-28_afip_relaciones laborales activas\\Relaciones_Laborales_Activas_2024-06-28.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 1 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-01_lsd", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 2 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-02_lsd\\ya procesado", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-02_lsd", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 3 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-03_lsd\\ya procesados", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 4 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-04_lsd", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 5 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-05_lsd", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV20mesNro == 6 ) || (0==AV20mesNro) )
      {
         AV17carpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\ARCHIVOS PROA\\LSD\\2024-06_lsd", "") ;
         /* Execute user subroutine: 'IMPORTAR CARPETA' */
         S121 ();
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
      /* 'IMPORTAR' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LIQUIDACIONES", "")) == 0 )
      {
         GXv_objcol_SdtMessages_Message1[0] = AV15messages ;
         GXv_boolean2[0] = AV16ok ;
         new web.importararchivolsd(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12ImpLiqSec, AV14dummy_ImpLiqLSDFile, AV8Path, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
         AV15messages = GXv_objcol_SdtMessages_Message1[0] ;
         importartodoslsd_test2.this.AV16ok = GXv_boolean2[0] ;
      }
      else
      {
         new web.importararchivolsdparalegajos(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12ImpLiqSec, AV8Path) ;
      }
   }

   public void S121( )
   {
      /* 'IMPORTAR CARPETA' Routine */
      returnInSub = false ;
      AV18directory.setSource( AV17carpeta );
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "carpeta ", "")+GXutil.trim( AV17carpeta)) ;
      AV25GXV2 = 1 ;
      AV24GXV1 = (com.genexus.util.GXFileCollection)AV18directory.getFiles("");
      while ( AV25GXV2 <= AV24GXV1.getItemCount() )
      {
         AV19file = (com.genexus.util.GXFile)AV24GXV1.item(AV25GXV2);
         AV8Path = AV19file.getURI() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "path ", "")+GXutil.trim( AV8Path)) ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if (returnInSub) return;
         AV25GXV2 = (int)(AV25GXV2+1) ;
      }
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
      AV17carpeta = "" ;
      AV8Path = "" ;
      AV14dummy_ImpLiqLSDFile = "" ;
      AV15messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV18directory = new com.genexus.util.GXDirectory();
      AV23Pgmname = "" ;
      AV24GXV1 = new com.genexus.util.GXFileCollection();
      AV19file = new com.genexus.util.GXFile();
      AV23Pgmname = "importarTodosLSD_test2" ;
      /* GeneXus formulas. */
      AV23Pgmname = "importarTodosLSD_test2" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV12ImpLiqSec ;
   private short AV20mesNro ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV25GXV2 ;
   private String AV13que ;
   private String AV23Pgmname ;
   private boolean returnInSub ;
   private boolean AV16ok ;
   private boolean GXv_boolean2[] ;
   private String AV14dummy_ImpLiqLSDFile ;
   private String AV17carpeta ;
   private String AV8Path ;
   private com.genexus.util.GXDirectory AV18directory ;
   private com.genexus.util.GXFile AV19file ;
   private com.genexus.util.GXFileCollection AV24GXV1 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
}

