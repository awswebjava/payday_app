package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getitemiconoimgpredeterminada extends GXProcedure
{
   public getitemiconoimgpredeterminada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getitemiconoimgpredeterminada.class ), "" );
   }

   public getitemiconoimgpredeterminada( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getitemiconoimgpredeterminada.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getitemiconoimgpredeterminada.this.AV8MenuItemId = aP0;
      getitemiconoimgpredeterminada.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&MenuItemId ", "")+AV8MenuItemId) ;
      if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Importar Legajos", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "importar_legajos", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Importar Liquidaciones Históricas", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "importar_liquidaciones", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Libro de Sueldos Digital", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "Libro_sueldo_digital", "") ;
      }
      else if ( GXutil.strcmp(AV8MenuItemId, httpContext.getMessage( "Formulario 1357", "")) == 0 )
      {
         AV9palabra = httpContext.getMessage( "formulario_1357", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "palabra ", "")+AV9palabra) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getitemiconoimgpredeterminada.this.AV9palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9palabra = "" ;
      AV12Pgmname = "" ;
      AV12Pgmname = "getItemIconoImgPredeterminada" ;
      /* GeneXus formulas. */
      AV12Pgmname = "getItemIconoImgPredeterminada" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9palabra ;
   private String AV12Pgmname ;
   private String AV8MenuItemId ;
   private String[] aP1 ;
}

