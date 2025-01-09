package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmanejafondocese extends GXProcedure
{
   public getmanejafondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmanejafondocese.class ), "" );
   }

   public getmanejafondocese( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 ,
                             boolean[] aP5 )
   {
      getmanejafondocese.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 )
   {
      getmanejafondocese.this.AV12CliCod = aP0;
      getmanejafondocese.this.AV10EmpCod = aP1;
      getmanejafondocese.this.AV11LegNumero = aP2;
      getmanejafondocese.this.AV15LiqPeriodo = aP3;
      getmanejafondocese.this.aP4 = aP4;
      getmanejafondocese.this.aP5 = aP5;
      getmanejafondocese.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8LegConveCodigo ;
      GXv_int2[0] = AV13PaiCod ;
      new web.empleadogetconvenio2(remoteHandle, context).execute( AV12CliCod, AV10EmpCod, AV11LegNumero, GXv_char1, GXv_int2) ;
      getmanejafondocese.this.AV8LegConveCodigo = GXv_char1[0] ;
      getmanejafondocese.this.AV13PaiCod = GXv_int2[0] ;
      if ( ! (GXutil.strcmp("", AV8LegConveCodigo)==0) )
      {
         GXv_boolean3[0] = AV14manejaFondoCese ;
         new web.getconvemanejafondocese(remoteHandle, context).execute( AV12CliCod, AV10EmpCod, AV11LegNumero, AV13PaiCod, AV15LiqPeriodo, AV8LegConveCodigo, GXv_boolean3) ;
         getmanejafondocese.this.AV14manejaFondoCese = GXv_boolean3[0] ;
      }
      if ( ! AV14manejaFondoCese )
      {
         GXv_boolean3[0] = AV14manejaFondoCese ;
         new web.getpaismanejafondocese(remoteHandle, context).execute( AV13PaiCod, GXv_boolean3) ;
         getmanejafondocese.this.AV14manejaFondoCese = GXv_boolean3[0] ;
         AV16porPaisEs = AV14manejaFondoCese ;
      }
      else
      {
         AV16porPaisEs = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmanejafondocese.this.AV14manejaFondoCese;
      this.aP5[0] = getmanejafondocese.this.AV16porPaisEs;
      this.aP6[0] = getmanejafondocese.this.AV8LegConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LegConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new short[1] ;
      GXv_boolean3 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV13PaiCod ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11LegNumero ;
   private String AV8LegConveCodigo ;
   private String GXv_char1[] ;
   private java.util.Date AV15LiqPeriodo ;
   private boolean AV14manejaFondoCese ;
   private boolean AV16porPaisEs ;
   private boolean GXv_boolean3[] ;
   private String[] aP6 ;
   private boolean[] aP4 ;
   private boolean[] aP5 ;
}

