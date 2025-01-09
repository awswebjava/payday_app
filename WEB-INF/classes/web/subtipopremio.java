package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class subtipopremio extends GXProcedure
{
   public subtipopremio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subtipopremio.class ), "" );
   }

   public subtipopremio( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      subtipopremio.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      subtipopremio.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8SubTipoConCod1 = httpContext.getMessage( "PREMIO", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = subtipopremio.this.AV8SubTipoConCod1;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SubTipoConCod1 = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SubTipoConCod1 ;
   private String[] aP0 ;
}

