package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresaconvetope extends GXProcedure
{
   public getempresaconvetope( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresaconvetope.class ), "" );
   }

   public getempresaconvetope( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 ,
                                           String[] aP4 )
   {
      getempresaconvetope.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String[] aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String[] aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      getempresaconvetope.this.AV9CliCod = aP0;
      getempresaconvetope.this.AV8EmpCod = aP1;
      getempresaconvetope.this.AV13LegNumero = aP2;
      getempresaconvetope.this.AV14LiqPeriodo = aP3;
      getempresaconvetope.this.aP4 = aP4;
      getempresaconvetope.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_char1[0] = AV11collection_ConveCodigo ;
      new web.getconveniosactividadempresa(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, GXv_objcol_char1) ;
      AV11collection_ConveCodigo = GXv_objcol_char1[0] ;
      AV12i = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&collection_ConveCodigo ", "")+GXutil.trim( GXutil.str( AV11collection_ConveCodigo.size(), 9, 0))) ;
      while ( AV12i <= AV11collection_ConveCodigo.size() )
      {
         GXv_decimal2[0] = AV15CliConveImporte ;
         new web.conveniogetimporte(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, AV13LegNumero, (String)AV11collection_ConveCodigo.elementAt(-1+AV12i), AV14LiqPeriodo, "TopeIndem", GXv_decimal2) ;
         getempresaconvetope.this.AV15CliConveImporte = GXv_decimal2[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&collection_ConveCodigo ", "")+GXutil.trim( (String)AV11collection_ConveCodigo.elementAt(-1+AV12i))+httpContext.getMessage( " &CliConveImporte ", "")+GXutil.trim( GXutil.str( AV15CliConveImporte, 14, 2))+httpContext.getMessage( " &max_Importes ", "")+GXutil.trim( GXutil.str( AV16max_Importes, 14, 2))) ;
         if ( DecimalUtil.compareTo(AV15CliConveImporte, AV16max_Importes) > 0 )
         {
            AV16max_Importes = AV15CliConveImporte ;
            AV17ConveCodigo = (String)AV11collection_ConveCodigo.elementAt(-1+AV12i) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+GXutil.trim( AV17ConveCodigo)) ;
         }
         AV12i = (short)(AV12i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getempresaconvetope.this.AV17ConveCodigo;
      this.aP5[0] = getempresaconvetope.this.AV16max_Importes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17ConveCodigo = "" ;
      AV16max_Importes = DecimalUtil.ZERO ;
      AV11collection_ConveCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char1 = new GXSimpleCollection[1] ;
      AV20Pgmname = "" ;
      AV15CliConveImporte = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV20Pgmname = "getEmpresaConveTope" ;
      /* GeneXus formulas. */
      AV20Pgmname = "getEmpresaConveTope" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV12i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV16max_Importes ;
   private java.math.BigDecimal AV15CliConveImporte ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV17ConveCodigo ;
   private String AV20Pgmname ;
   private java.util.Date AV14LiqPeriodo ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV11collection_ConveCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char1[] ;
}

