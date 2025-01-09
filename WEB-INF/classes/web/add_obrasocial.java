package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class add_obrasocial extends GXProcedure
{
   public add_obrasocial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( add_obrasocial.class ), "" );
   }

   public add_obrasocial( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      add_obrasocial.this.AV11clicod = aP0;
      add_obrasocial.this.AV10codigo = aP1;
      add_obrasocial.this.AV8OsoDescrip = aP2;
      add_obrasocial.this.AV9OsoSigla = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12OsoCod = GXutil.trim( AV10codigo) ;
      AV14OsoC3992 = GXutil.strReplace( GXutil.trim( AV10codigo), "-", "") ;
      if ( ! (GXutil.strcmp("", AV9OsoSigla)==0) )
      {
         AV15OsoSiglaYDesc = GXutil.trim( AV9OsoSigla) + " " + GXutil.trim( AV8OsoDescrip) ;
      }
      else
      {
         AV15OsoSiglaYDesc = AV8OsoDescrip ;
      }
      if ( GXutil.strcmp(AV9OsoSigla, httpContext.getMessage( "OSECAC", "")) == 0 )
      {
         AV16OsoAporteAdic = DecimalUtil.doubleToDec(100) ;
      }
      else
      {
         AV16OsoAporteAdic = DecimalUtil.ZERO ;
      }
      AV17os_construccion.add("107800", 0);
      AV17os_construccion.add("110206", 0);
      AV17os_construccion.add("112004", 0);
      AV17os_construccion.add("123305", 0);
      AV17os_construccion.add("126700", 0);
      AV17os_construccion.add("303703", 0);
      AV17os_construccion.add("400107", 0);
      AV17os_construccion.add(httpContext.getMessage( "OSCOEMA", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSEN", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSMATA", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSMMEDT", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSPATCA", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSPECON", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSPIF", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSPRERA", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSSACRA", ""), 0);
      AV17os_construccion.add(httpContext.getMessage( "OSTEL", ""), 0);
      if ( ( (AV17os_construccion.indexof(GXutil.rtrim( AV12OsoCod))>0) ) || ( (AV17os_construccion.indexof(GXutil.rtrim( AV9OsoSigla))>0) ) || ( (AV17os_construccion.indexof(GXutil.rtrim( AV14OsoC3992))>0) ) )
      {
         GXt_char1 = AV18OsoActCom ;
         GXv_char2[0] = GXt_char1 ;
         new web.actcomconstruccion(remoteHandle, context).execute( GXv_char2) ;
         add_obrasocial.this.GXt_char1 = GXv_char2[0] ;
         AV18OsoActCom = GXt_char1 ;
      }
      else
      {
         AV19os_grales.add(httpContext.getMessage( "OSDE", ""), 0);
         AV19os_grales.add(httpContext.getMessage( "OSECAC", ""), 0);
         AV19os_grales.add(httpContext.getMessage( "OSPAÑA", ""), 0);
         if ( ( (AV19os_grales.indexof(GXutil.rtrim( AV12OsoCod))>0) ) || ( (AV19os_grales.indexof(GXutil.rtrim( AV9OsoSigla))>0) ) || ( (AV19os_grales.indexof(GXutil.rtrim( AV14OsoC3992))>0) ) )
         {
            AV18OsoActCom = "" ;
         }
         else
         {
            AV18OsoActCom = httpContext.getMessage( "OTRA", "") ;
         }
      }
      new web.newobrasocial(remoteHandle, context).execute( AV11clicod, AV12OsoCod, AV8OsoDescrip, AV9OsoSigla, true, AV14OsoC3992, AV15OsoSiglaYDesc, AV16OsoAporteAdic, AV18OsoActCom) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12OsoCod = "" ;
      AV14OsoC3992 = "" ;
      AV15OsoSiglaYDesc = "" ;
      AV16OsoAporteAdic = DecimalUtil.ZERO ;
      AV17os_construccion = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18OsoActCom = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV19os_grales = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11clicod ;
   private java.math.BigDecimal AV16OsoAporteAdic ;
   private String AV10codigo ;
   private String AV9OsoSigla ;
   private String AV12OsoCod ;
   private String AV14OsoC3992 ;
   private String AV18OsoActCom ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV8OsoDescrip ;
   private String AV15OsoSiglaYDesc ;
   private GXSimpleCollection<String> AV17os_construccion ;
   private GXSimpleCollection<String> AV19os_grales ;
}

