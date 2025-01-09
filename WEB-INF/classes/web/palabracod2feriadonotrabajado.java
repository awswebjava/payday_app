package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class palabracod2feriadonotrabajado extends GXProcedure
{
   public palabracod2feriadonotrabajado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( palabracod2feriadonotrabajado.class ), "" );
   }

   public palabracod2feriadonotrabajado( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      palabracod2feriadonotrabajado.this.aP1 = new String[] {""};
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
      palabracod2feriadonotrabajado.this.AV9clicod = aP0;
      palabracod2feriadonotrabajado.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = httpContext.getMessage( "No Trabajado", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = palabracod2feriadonotrabajado.this.AV8palabra;
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

