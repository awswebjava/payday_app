package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armaliqnombre2 extends GXProcedure
{
   public armaliqnombre2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armaliqnombre2.class ), "" );
   }

   public armaliqnombre2( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             GXSimpleCollection<String> aP8 ,
                             GXSimpleCollection<String> aP9 ,
                             GXSimpleCollection<String> aP10 ,
                             GXSimpleCollection<String> aP11 ,
                             GXSimpleCollection<String> aP12 )
   {
      armaliqnombre2.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 ,
                        String aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        GXSimpleCollection<String> aP8 ,
                        GXSimpleCollection<String> aP9 ,
                        GXSimpleCollection<String> aP10 ,
                        GXSimpleCollection<String> aP11 ,
                        GXSimpleCollection<String> aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             GXSimpleCollection<String> aP8 ,
                             GXSimpleCollection<String> aP9 ,
                             GXSimpleCollection<String> aP10 ,
                             GXSimpleCollection<String> aP11 ,
                             GXSimpleCollection<String> aP12 ,
                             String[] aP13 )
   {
      armaliqnombre2.this.AV12CliCod = aP0;
      armaliqnombre2.this.AV25EmpCod = aP1;
      armaliqnombre2.this.AV14LiqPeriodo = aP2;
      armaliqnombre2.this.AV9LiqPerPalabra = aP3[0];
      this.aP3 = aP3;
      armaliqnombre2.this.AV11TLiqCod = aP4;
      armaliqnombre2.this.AV27TLiqModTra = aP5;
      armaliqnombre2.this.AV28TLiqFrecPag = aP6;
      armaliqnombre2.this.AV15ConvenioFiltro = aP7;
      armaliqnombre2.this.AV16ConveCodigo = aP8;
      armaliqnombre2.this.AV18CatCodigo = aP9;
      armaliqnombre2.this.AV20SecCodigo = aP10;
      armaliqnombre2.this.AV22PuestoCodigo = aP11;
      armaliqnombre2.this.AV24SucCodigo = aP12;
      armaliqnombre2.this.aP13 = aP13;
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
         armaliqnombre2.this.AV9LiqPerPalabra = GXv_char1[0] ;
      }
      AV8LiqNombre = GXutil.trim( AV9LiqPerPalabra) ;
      GXv_char1[0] = AV29TLiqDescAuxFrec ;
      new web.gettliqmodfrecdesc(remoteHandle, context).execute( AV12CliCod, AV11TLiqCod, AV27TLiqModTra, AV28TLiqFrecPag, GXv_char1) ;
      armaliqnombre2.this.AV29TLiqDescAuxFrec = GXv_char1[0] ;
      AV8LiqNombre += " - " + GXutil.trim( AV29TLiqDescAuxFrec) ;
      if ( GXutil.strcmp(AV15ConvenioFiltro, "Fuera") == 0 )
      {
         AV8LiqNombre += httpContext.getMessage( " - FUERA DE CONVENIO", "") ;
      }
      if ( AV16ConveCodigo.size() > 0 )
      {
         if ( AV16ConveCodigo.size() == 1 )
         {
            GXv_char1[0] = AV17ConveDescri ;
            GXv_boolean2[0] = true ;
            new web.getconvenio(remoteHandle, context).execute( AV12CliCod, (String)AV16ConveCodigo.elementAt(-1+1), GXv_char1, GXv_boolean2) ;
            armaliqnombre2.this.AV17ConveDescri = GXv_char1[0] ;
            AV8LiqNombre += " - " + GXutil.trim( GXutil.upper( AV17ConveDescri)) ;
         }
         else
         {
            AV8LiqNombre += " - " + GXutil.trim( GXutil.str( AV16ConveCodigo.size(), 9, 0)) + httpContext.getMessage( " convenios", "") ;
         }
      }
      if ( AV18CatCodigo.size() > 0 )
      {
         if ( ( AV18CatCodigo.size() == 1 ) && ( AV16ConveCodigo.size() == 1 ) )
         {
            GXv_char1[0] = AV19CatDescrip ;
            GXv_boolean2[0] = true ;
            new web.getcategoria(remoteHandle, context).execute( AV12CliCod, AV12CliCod, (String)AV16ConveCodigo.elementAt(-1+1), (String)AV18CatCodigo.elementAt(-1+1), GXv_char1, GXv_boolean2) ;
            armaliqnombre2.this.AV19CatDescrip = GXv_char1[0] ;
            AV8LiqNombre += " - " + GXutil.trim( GXutil.upper( AV19CatDescrip)) ;
         }
         else
         {
            AV8LiqNombre += " - " + GXutil.trim( GXutil.str( AV18CatCodigo.size(), 9, 0)) + httpContext.getMessage( " categorías", "") ;
         }
      }
      if ( AV20SecCodigo.size() > 0 )
      {
         if ( AV20SecCodigo.size() == 1 )
         {
            GXv_char1[0] = AV21SecDescrip ;
            GXv_boolean2[0] = true ;
            new web.getseccion(remoteHandle, context).execute( AV12CliCod, (String)AV20SecCodigo.elementAt(-1+1), GXv_char1, GXv_boolean2) ;
            armaliqnombre2.this.AV21SecDescrip = GXv_char1[0] ;
            AV8LiqNombre += " - " + GXutil.trim( GXutil.upper( AV21SecDescrip)) ;
         }
         else
         {
            AV8LiqNombre += " - " + GXutil.trim( GXutil.str( AV20SecCodigo.size(), 9, 0)) + httpContext.getMessage( " áreas", "") ;
         }
      }
      if ( AV22PuestoCodigo.size() > 0 )
      {
         if ( ( AV22PuestoCodigo.size() == 1 ) && ( AV20SecCodigo.size() == 1 ) )
         {
            GXv_char1[0] = AV23PuestoDescrip ;
            new web.getpuesto(remoteHandle, context).execute( AV12CliCod, (String)AV20SecCodigo.elementAt(-1+1), (String)AV22PuestoCodigo.elementAt(-1+1), GXv_char1) ;
            armaliqnombre2.this.AV23PuestoDescrip = GXv_char1[0] ;
            AV8LiqNombre += " - " + GXutil.trim( GXutil.upper( AV23PuestoDescrip)) ;
         }
         else
         {
            AV8LiqNombre += " - " + GXutil.trim( GXutil.str( AV22PuestoCodigo.size(), 9, 0)) + httpContext.getMessage( " puestos", "") ;
         }
      }
      if ( AV24SucCodigo.size() > 0 )
      {
         if ( AV24SucCodigo.size() == 1 )
         {
            GXv_char1[0] = AV26SucDescrip ;
            new web.getsucursal(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, (String)AV24SucCodigo.elementAt(-1+1), GXv_char1) ;
            armaliqnombre2.this.AV26SucDescrip = GXv_char1[0] ;
            AV8LiqNombre += " - " + GXutil.trim( GXutil.upper( AV26SucDescrip)) ;
         }
         else
         {
            AV8LiqNombre += " - " + GXutil.trim( GXutil.str( AV24SucCodigo.size(), 9, 0)) + httpContext.getMessage( " sucursales", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = armaliqnombre2.this.AV9LiqPerPalabra;
      this.aP13[0] = armaliqnombre2.this.AV8LiqNombre;
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
      AV29TLiqDescAuxFrec = "" ;
      AV17ConveDescri = "" ;
      AV19CatDescrip = "" ;
      AV21SecDescrip = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV23PuestoDescrip = "" ;
      AV26SucDescrip = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV28TLiqFrecPag ;
   private short AV25EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV9LiqPerPalabra ;
   private String AV11TLiqCod ;
   private String AV27TLiqModTra ;
   private String AV15ConvenioFiltro ;
   private String GXv_char1[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean GXv_boolean2[] ;
   private String AV8LiqNombre ;
   private String AV29TLiqDescAuxFrec ;
   private String AV17ConveDescri ;
   private String AV19CatDescrip ;
   private String AV21SecDescrip ;
   private String AV23PuestoDescrip ;
   private String AV26SucDescrip ;
   private String[] aP13 ;
   private String[] aP3 ;
   private GXSimpleCollection<String> AV16ConveCodigo ;
   private GXSimpleCollection<String> AV18CatCodigo ;
   private GXSimpleCollection<String> AV20SecCodigo ;
   private GXSimpleCollection<String> AV22PuestoCodigo ;
   private GXSimpleCollection<String> AV24SucCodigo ;
}

