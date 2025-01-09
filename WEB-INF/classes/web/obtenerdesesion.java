package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerdesesion extends GXProcedure
{
   public obtenerdesesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerdesesion.class ), "" );
   }

   public obtenerdesesion( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      obtenerdesesion.this.aP1 = new String[] {""};
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
      obtenerdesesion.this.AV8key = aP0;
      obtenerdesesion.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9value = AV10websession.getValue(AV8key) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = obtenerdesesion.this.AV9value;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9value = "" ;
      AV10websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8key ;
   private String AV9value ;
   private com.genexus.webpanels.WebSession AV10websession ;
   private String[] aP1 ;
}

