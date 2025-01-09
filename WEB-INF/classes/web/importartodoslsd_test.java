package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importartodoslsd_test extends GXProcedure
{
   public importartodoslsd_test( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importartodoslsd_test.class ), "" );
   }

   public importartodoslsd_test( int remoteHandle ,
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
      importartodoslsd_test.this.AV10CliCod = aP0;
      importartodoslsd_test.this.AV11EmpCod = aP1;
      importartodoslsd_test.this.AV12ImpLiqSec = aP2;
      importartodoslsd_test.this.AV13que = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9lsdCarpeta = httpContext.getMessage( "C:\\sueldos\\migracion\\LSD-20240612T191507Z-001\\LSD\\", "") ;
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LEGAJOS", "")) == 0 )
      {
         AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "ConsRelLab25062024.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "ConsDatComp25062024.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Enero 2024\\enero ___Liquidacion_2_30716165805_20240612151412.txt", "") ;
      /* Execute user subroutine: 'IMPORTAR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LIQUIDACIONES", "")) == 0 )
      {
         AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Enero 2024\\enero egreso ___Liquidacion_1_30716165805_20240612151416.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Febrero 2024\\febrero ___Liquidacion_2_30716165805_20240612151455.txt", "") ;
      /* Execute user subroutine: 'IMPORTAR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LIQUIDACIONES", "")) == 0 )
      {
         AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Febrero 2024\\febrero egreso___Liquidacion_1_30716165805_20240612151458.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Marzo 2024\\marzo ___Liquidacion_1_30716165805_20240612151540.txt", "") ;
      /* Execute user subroutine: 'IMPORTAR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Abril 2024\\abril ___Liquidacion_3_30716165805_20240612151625.txt", "") ;
      /* Execute user subroutine: 'IMPORTAR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(AV13que, httpContext.getMessage( "LIQUIDACIONES", "")) == 0 )
      {
         AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Abril 2024\\abril egreso ___Liquidacion_2_30716165805_20240612151629.txt", "") ;
         /* Execute user subroutine: 'IMPORTAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV8Path = GXutil.trim( AV9lsdCarpeta) + httpContext.getMessage( "Mayo 2024\\mayo ___Liquidacion_1_30716165805_20240612151328.txt", "") ;
      /* Execute user subroutine: 'IMPORTAR' */
      S111 ();
      if ( returnInSub )
      {
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
         importartodoslsd_test.this.AV16ok = GXv_boolean2[0] ;
      }
      else
      {
         new web.importararchivolsdparalegajos(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12ImpLiqSec, AV8Path) ;
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
      AV9lsdCarpeta = "" ;
      AV8Path = "" ;
      AV14dummy_ImpLiqLSDFile = "" ;
      AV15messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      GXv_boolean2 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV12ImpLiqSec ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV13que ;
   private boolean returnInSub ;
   private boolean AV16ok ;
   private boolean GXv_boolean2[] ;
   private String AV14dummy_ImpLiqLSDFile ;
   private String AV9lsdCarpeta ;
   private String AV8Path ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
}

