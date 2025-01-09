package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recalgandependenciaresuelta extends GXProcedure
{
   public recalgandependenciaresuelta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recalgandependenciaresuelta.class ), "" );
   }

   public recalgandependenciaresuelta( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( short aP0 )
   {
      recalgandependenciaresuelta.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 )
   {
      recalgandependenciaresuelta.this.AV8LiqDRecalculado = aP0;
      recalgandependenciaresuelta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&LiqDRecalculado ", "")+GXutil.trim( GXutil.str( AV8LiqDRecalculado, 4, 0))) ;
      if ( AV8LiqDRecalculado == 2 )
      {
         AV9Calculado = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "sirecalcu1", "")) ;
      }
      else
      {
         if ( AV8LiqDRecalculado == 1 )
         {
            AV9Calculado = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "sirecalcu2", "")) ;
         }
         else
         {
            AV9Calculado = (byte)(0) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "sirecalcu2", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = recalgandependenciaresuelta.this.AV9Calculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Pgmname = "" ;
      AV12Pgmname = "recalGanDependenciaResuelta" ;
      /* GeneXus formulas. */
      AV12Pgmname = "recalGanDependenciaResuelta" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9Calculado ;
   private short AV8LiqDRecalculado ;
   private short Gx_err ;
   private String AV12Pgmname ;
   private byte[] aP1 ;
}

