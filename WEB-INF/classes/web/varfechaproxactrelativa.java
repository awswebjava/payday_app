package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class varfechaproxactrelativa extends GXProcedure
{
   public varfechaproxactrelativa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( varfechaproxactrelativa.class ), "" );
   }

   public varfechaproxactrelativa( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 )
   {
      varfechaproxactrelativa.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 )
   {
      varfechaproxactrelativa.this.AV10CliCod = aP0;
      varfechaproxactrelativa.this.AV9OpeCliId = aP1;
      varfechaproxactrelativa.this.AV13Fecha = aP2;
      varfechaproxactrelativa.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV12VarFrecAct ;
      new web.getvarfrectact(remoteHandle, context).execute( AV10CliCod, AV9OpeCliId, GXv_int1) ;
      varfechaproxactrelativa.this.AV12VarFrecAct = GXv_int1[0] ;
      GXv_date2[0] = AV8ultiOpeCliVig ;
      new web.getultifecvar(remoteHandle, context).execute( AV10CliCod, AV9OpeCliId, AV13Fecha, GXv_date2) ;
      varfechaproxactrelativa.this.AV8ultiOpeCliVig = GXv_date2[0] ;
      if ( AV12VarFrecAct > 0 )
      {
         AV11OpeCliVig = GXutil.addmth( AV8ultiOpeCliVig, AV12VarFrecAct) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = varfechaproxactrelativa.this.AV11OpeCliVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11OpeCliVig = GXutil.nullDate() ;
      GXv_int1 = new byte[1] ;
      AV8ultiOpeCliVig = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12VarFrecAct ;
   private byte GXv_int1[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV9OpeCliId ;
   private java.util.Date AV13Fecha ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date AV8ultiOpeCliVig ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date[] aP3 ;
}

