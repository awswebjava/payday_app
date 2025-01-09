package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatosactividadempresa extends GXProcedure
{
   public getsindicatosactividadempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatosactividadempresa.class ), "" );
   }

   public getsindicatosactividadempresa( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 )
   {
      getsindicatosactividadempresa.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      getsindicatosactividadempresa.this.AV10CliCod = aP0;
      getsindicatosactividadempresa.this.AV8EmpCod = aP1;
      getsindicatosactividadempresa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9ActComCodigo ;
      new web.empresagetactcomercial(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, GXv_char1) ;
      getsindicatosactividadempresa.this.AV9ActComCodigo = GXv_char1[0] ;
      GXt_int2 = AV12PaiCod ;
      GXv_int3[0] = GXt_int2 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int3) ;
      getsindicatosactividadempresa.this.GXt_int2 = GXv_int3[0] ;
      AV12PaiCod = GXt_int2 ;
      GXv_objcol_char4[0] = AV11SinCod ;
      new web.getsindicatosporactcomercial(remoteHandle, context).execute( AV12PaiCod, AV9ActComCodigo, GXv_objcol_char4) ;
      AV11SinCod = GXv_objcol_char4[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatosactividadempresa.this.AV11SinCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9ActComCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_int3 = new short[1] ;
      GXv_objcol_char4 = new GXSimpleCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV12PaiCod ;
   private short GXt_int2 ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV9ActComCodigo ;
   private String GXv_char1[] ;
   private GXSimpleCollection<String>[] aP2 ;
   private GXSimpleCollection<String> AV11SinCod ;
   private GXSimpleCollection<String> GXv_objcol_char4[] ;
}

