package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armaperpalabra extends GXProcedure
{
   public armaperpalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armaperpalabra.class ), "" );
   }

   public armaperpalabra( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.util.Date aP1 )
   {
      armaperpalabra.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             String[] aP2 )
   {
      armaperpalabra.this.AV11CliCod = aP0;
      armaperpalabra.this.AV9LiqPeriodo = aP1;
      armaperpalabra.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12mesPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.armamespalabra(remoteHandle, context).execute( AV11CliCod, AV9LiqPeriodo, GXv_char2) ;
      armaperpalabra.this.GXt_char1 = GXv_char2[0] ;
      AV12mesPalabra = GXt_char1 ;
      AV10LiqPerPalabra = GXutil.trim( AV12mesPalabra) ;
      AV10LiqPerPalabra += " " + GXutil.trim( GXutil.str( GXutil.year( AV9LiqPeriodo), 10, 0)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = armaperpalabra.this.AV10LiqPerPalabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqPerPalabra = "" ;
      AV12mesPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10LiqPerPalabra ;
   private String AV12mesPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date AV9LiqPeriodo ;
   private String[] aP2 ;
}

