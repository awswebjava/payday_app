package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reemplazafinalporvalor extends GXProcedure
{
   public reemplazafinalporvalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reemplazafinalporvalor.class ), "" );
   }

   public reemplazafinalporvalor( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      reemplazafinalporvalor.this.aP1 = new String[] {""};
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
      reemplazafinalporvalor.this.AV9valor = aP0;
      reemplazafinalporvalor.this.AV8palabra = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = GXutil.strReplace( AV8palabra, "]", " "+GXutil.trim( AV9valor)+"]") ;
      AV8palabra = GXutil.strReplace( AV8palabra, "}", " "+GXutil.trim( AV9valor)+"}") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = reemplazafinalporvalor.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9valor ;
   private String AV8palabra ;
   private String[] aP1 ;
}

