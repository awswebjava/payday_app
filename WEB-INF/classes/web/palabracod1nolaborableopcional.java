package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class palabracod1nolaborableopcional extends GXProcedure
{
   public palabracod1nolaborableopcional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( palabracod1nolaborableopcional.class ), "" );
   }

   public palabracod1nolaborableopcional( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      palabracod1nolaborableopcional.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      palabracod1nolaborableopcional.this.AV9clicod = aP0;
      palabracod1nolaborableopcional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = httpContext.getMessage( "Opcional", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = palabracod1nolaborableopcional.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9clicod ;
   private String AV8palabra ;
   private String[] aP1 ;
}

