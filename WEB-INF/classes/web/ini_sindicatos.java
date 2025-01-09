package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_sindicatos extends GXProcedure
{
   public ini_sindicatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_sindicatos.class ), "" );
   }

   public ini_sindicatos( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> executeUdp( int aP0 )
   {
      ini_sindicatos.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP1 )
   {
      ini_sindicatos.this.AV9CliCod = aP0;
      ini_sindicatos.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "1 ") ;
      GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] = AV8sdt_sindicato ;
      new web.add_sindicato(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "UECARA", ""), httpContext.getMessage( "UECARA - Unión Empleados de la Construcción y Afines de la República Argentina", ""), GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1) ;
      AV8sdt_sindicato = GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "2 ") ;
      GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] = AV8sdt_sindicato ;
      new web.add_sindicato(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "UOCRA", ""), httpContext.getMessage( "UOCRA - Unión Obrera de la Construcción de la República Argentina", ""), GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1) ;
      AV8sdt_sindicato = GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "3") ;
      GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] = AV8sdt_sindicato ;
      new web.add_sindicato(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "UOCRAYAC", ""), httpContext.getMessage( "UOCRAYAC - UOCRA Yacimiento", ""), GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1) ;
      AV8sdt_sindicato = GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, "4") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = ini_sindicatos.this.AV8sdt_sindicato;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sdt_sindicato = new GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>(web.Sdtsdt_sindicato_sdt_sindicatoItem.class, "sdt_sindicatoItem", "PayDay", remoteHandle);
      AV12Pgmname = "" ;
      GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1 = new GXBaseCollection[1] ;
      AV12Pgmname = "ini_sindicatos" ;
      /* GeneXus formulas. */
      AV12Pgmname = "ini_sindicatos" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV12Pgmname ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>[] aP1 ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> AV8sdt_sindicato ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem1[] ;
}

