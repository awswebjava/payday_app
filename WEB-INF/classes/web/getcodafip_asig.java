package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcodafip_asig extends GXProcedure
{
   public getcodafip_asig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcodafip_asig.class ), "" );
   }

   public getcodafip_asig( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      getcodafip_asig.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      getcodafip_asig.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8codigo = httpContext.getMessage( "ASIGNACION", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getcodafip_asig.this.AV8codigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8codigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8codigo ;
   private String[] aP0 ;
}

