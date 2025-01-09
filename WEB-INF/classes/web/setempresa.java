package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setempresa extends GXProcedure
{
   public setempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setempresa.class ), "" );
   }

   public setempresa( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      setempresa.this.AV9EmpCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( httpContext.getMessage( "EmpCod", ""), GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
      cleanup();
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
      AV12Pgmname = "" ;
      AV12Pgmname = "SetEmpresa" ;
      /* GeneXus formulas. */
      AV12Pgmname = "SetEmpresa" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private String AV12Pgmname ;
}

