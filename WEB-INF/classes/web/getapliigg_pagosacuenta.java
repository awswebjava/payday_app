package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliigg_pagosacuenta extends GXProcedure
{
   public getapliigg_pagosacuenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliigg_pagosacuenta.class ), "" );
   }

   public getapliigg_pagosacuenta( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getapliigg_pagosacuenta.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getapliigg_pagosacuenta.this.AV8CliCod = aP0;
      getapliigg_pagosacuenta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV18ConCodigo ;
      GXt_char2 = AV18ConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.retencionbruta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getapliigg_pagosacuenta.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      getapliigg_pagosacuenta.this.GXt_char1 = GXv_char4[0] ;
      AV18ConCodigo = GXt_char1 ;
      GXt_int5 = AV11AplIIGG ;
      GXv_int6[0] = GXt_int5 ;
      new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV9AplIIGGTrat, (byte)(2), DecimalUtil.doubleToDec(1), "", AV18ConCodigo, "", GXv_int6) ;
      getapliigg_pagosacuenta.this.GXt_int5 = GXv_int6[0] ;
      AV11AplIIGG = GXt_int5 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getapliigg_pagosacuenta.this.AV11AplIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18ConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_int6 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9AplIIGGTrat ;
   private short AV11AplIIGG ;
   private short GXt_int5 ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV18ConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private short[] aP1 ;
}

