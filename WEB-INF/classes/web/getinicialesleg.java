package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getinicialesleg extends GXProcedure
{
   public getinicialesleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getinicialesleg.class ), "" );
   }

   public getinicialesleg( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      getinicialesleg.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getinicialesleg.this.AV8LegNombre = aP0;
      getinicialesleg.this.AV9LegApellido = aP1;
      getinicialesleg.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10iniciales = GXutil.substring( GXutil.upper( AV8LegNombre), 1, 1) + GXutil.substring( GXutil.upper( AV9LegApellido), 1, 1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getinicialesleg.this.AV10iniciales;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10iniciales = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10iniciales ;
   private String AV8LegNombre ;
   private String AV9LegApellido ;
   private String[] aP2 ;
}

