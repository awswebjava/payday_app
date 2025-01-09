package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class removercorchetes extends GXProcedure
{
   public removercorchetes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( removercorchetes.class ), "" );
   }

   public removercorchetes( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      removercorchetes.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      removercorchetes.this.AV8palabra = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8palabra ;
      new web.replacecomienzo(remoteHandle, context).execute( GXv_char1) ;
      removercorchetes.this.AV8palabra = GXv_char1[0] ;
      GXv_char1[0] = AV8palabra ;
      new web.replacefinal(remoteHandle, context).execute( GXv_char1) ;
      removercorchetes.this.AV8palabra = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = removercorchetes.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8palabra ;
   private String GXv_char1[] ;
   private String[] aP0 ;
}

