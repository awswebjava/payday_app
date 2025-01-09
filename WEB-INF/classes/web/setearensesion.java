package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearensesion extends GXProcedure
{
   public setearensesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearensesion.class ), "" );
   }

   public setearensesion( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      setearensesion.this.AV9key = aP0;
      setearensesion.this.AV10value = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8websession.setValue(AV9key, AV10value);
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
      AV8websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9key ;
   private String AV10value ;
   private com.genexus.webpanels.WebSession AV8websession ;
}

