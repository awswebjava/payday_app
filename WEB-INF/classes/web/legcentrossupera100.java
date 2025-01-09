package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legcentrossupera100 extends GXProcedure
{
   public legcentrossupera100( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legcentrossupera100.class ), "" );
   }

   public legcentrossupera100( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           int aP4 ,
                                           java.math.BigDecimal aP5 ,
                                           boolean[] aP6 )
   {
      legcentrossupera100.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        java.math.BigDecimal aP5 ,
                        boolean[] aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             java.math.BigDecimal aP5 ,
                             boolean[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      legcentrossupera100.this.Gx_mode = aP0;
      legcentrossupera100.this.AV14CenCodigo = aP1;
      legcentrossupera100.this.AV10clicod = aP2;
      legcentrossupera100.this.AV9empcod = aP3;
      legcentrossupera100.this.AV8legnumero = aP4;
      legcentrossupera100.this.AV12nuevo = aP5;
      legcentrossupera100.this.aP6 = aP6;
      legcentrossupera100.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 )
      {
         GXv_decimal1[0] = AV11LegCenPrc ;
         new web.legcentrostotleg(remoteHandle, context).execute( AV14CenCodigo, AV10clicod, AV9empcod, AV8legnumero, GXv_decimal1) ;
         legcentrossupera100.this.AV11LegCenPrc = GXv_decimal1[0] ;
      }
      else
      {
         GXv_decimal1[0] = AV11LegCenPrc ;
         new web.legcentrostotleg(remoteHandle, context).execute( (short)(0), AV10clicod, AV9empcod, AV8legnumero, GXv_decimal1) ;
         legcentrossupera100.this.AV11LegCenPrc = GXv_decimal1[0] ;
      }
      AV11LegCenPrc = AV11LegCenPrc.add(AV12nuevo) ;
      if ( AV11LegCenPrc.doubleValue() > 100 )
      {
         AV13supera = true ;
      }
      new web.msgdebug(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "&LegCenPrc ", "")+GXutil.trim( GXutil.str( AV11LegCenPrc, 6, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = legcentrossupera100.this.AV13supera;
      this.aP7[0] = legcentrossupera100.this.AV11LegCenPrc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegCenPrc = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV18Pgmname = "" ;
      AV18Pgmname = "LegCentrosSupera100" ;
      /* GeneXus formulas. */
      AV18Pgmname = "LegCentrosSupera100" ;
      Gx_err = (short)(0) ;
   }

   private short AV14CenCodigo ;
   private short AV9empcod ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV8legnumero ;
   private java.math.BigDecimal AV12nuevo ;
   private java.math.BigDecimal AV11LegCenPrc ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String Gx_mode ;
   private String AV18Pgmname ;
   private boolean AV13supera ;
   private java.math.BigDecimal[] aP7 ;
   private boolean[] aP6 ;
}

