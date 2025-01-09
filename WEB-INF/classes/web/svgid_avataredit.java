package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class svgid_avataredit extends GXProcedure
{
   public svgid_avataredit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( svgid_avataredit.class ), "" );
   }

   public svgid_avataredit( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      svgid_avataredit.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      svgid_avataredit.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8SVGId = httpContext.getMessage( "avatar_edit", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = svgid_avataredit.this.AV8SVGId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SVGId = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SVGId ;
   private String[] aP0 ;
}

