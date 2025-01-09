package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class subtipo2devolucionimpganancias extends GXProcedure
{
   public subtipo2devolucionimpganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subtipo2devolucionimpganancias.class ), "" );
   }

   public subtipo2devolucionimpganancias( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      subtipo2devolucionimpganancias.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      subtipo2devolucionimpganancias.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8palabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipoganancias(remoteHandle, context).execute( GXv_char2) ;
      subtipo2devolucionimpganancias.this.GXt_char1 = GXv_char2[0] ;
      AV8palabra = GXt_char1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = subtipo2devolucionimpganancias.this.AV8palabra;
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
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8palabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String[] aP0 ;
}

