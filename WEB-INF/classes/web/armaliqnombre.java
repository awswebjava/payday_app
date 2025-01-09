package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armaliqnombre extends GXProcedure
{
   public armaliqnombre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armaliqnombre.class ), "" );
   }

   public armaliqnombre( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.util.Date aP1 ,
                             String[] aP2 ,
                             String aP3 ,
                             String aP4 ,
                             byte aP5 )
   {
      armaliqnombre.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        String[] aP2 ,
                        String aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             String[] aP2 ,
                             String aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             String[] aP6 )
   {
      armaliqnombre.this.AV12CliCod = aP0;
      armaliqnombre.this.AV14LiqPeriodo = aP1;
      armaliqnombre.this.AV9LiqPerPalabra = aP2[0];
      this.aP2 = aP2;
      armaliqnombre.this.AV11TLiqCod = aP3;
      armaliqnombre.this.AV16TLiqModTra = aP4;
      armaliqnombre.this.AV17TLiqFrecPag = aP5;
      armaliqnombre.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV9LiqPerPalabra)==0) )
      {
         GXv_char1[0] = AV9LiqPerPalabra ;
         new web.armaperpalabra(remoteHandle, context).execute( AV12CliCod, AV14LiqPeriodo, GXv_char1) ;
         armaliqnombre.this.AV9LiqPerPalabra = GXv_char1[0] ;
      }
      AV8LiqNombre = GXutil.trim( AV9LiqPerPalabra) ;
      GXv_char1[0] = AV18TLiqDescAuxFrec ;
      new web.gettliqmodfrecdesc(remoteHandle, context).execute( AV12CliCod, AV11TLiqCod, AV16TLiqModTra, AV17TLiqFrecPag, GXv_char1) ;
      armaliqnombre.this.AV18TLiqDescAuxFrec = GXv_char1[0] ;
      AV8LiqNombre += " - " + GXutil.trim( AV18TLiqDescAuxFrec) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = armaliqnombre.this.AV9LiqPerPalabra;
      this.aP6[0] = armaliqnombre.this.AV8LiqNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqNombre = "" ;
      AV18TLiqDescAuxFrec = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17TLiqFrecPag ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV9LiqPerPalabra ;
   private String AV11TLiqCod ;
   private String AV16TLiqModTra ;
   private String GXv_char1[] ;
   private java.util.Date AV14LiqPeriodo ;
   private String AV8LiqNombre ;
   private String AV18TLiqDescAuxFrec ;
   private String[] aP6 ;
   private String[] aP2 ;
}

