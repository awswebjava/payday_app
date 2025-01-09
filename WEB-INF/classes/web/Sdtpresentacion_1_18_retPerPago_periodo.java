package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_retPerPago_periodo extends GxUserType
{
   public Sdtpresentacion_1_18_retPerPago_periodo( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_retPerPago_periodo.class));
   }

   public Sdtpresentacion_1_18_retPerPago_periodo( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_retPerPago_periodo");
   }

   public Sdtpresentacion_1_18_retPerPago_periodo( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_retPerPago_periodo");
   }

   public Sdtpresentacion_1_18_retPerPago_periodo( StructSdtpresentacion_1_18_retPerPago_periodo struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      if ( oReader.existsAttribute("mesDesde") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde = (byte)(getnumericvalue(oReader.getAttributeByName("mesDesde"))) ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("mesHasta") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta = (byte)(getnumericvalue(oReader.getAttributeByName("mesHasta"))) ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("montoMensual") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual = DecimalUtil.stringToDec( oReader.getAttributeByName("montoMensual")) ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "presentacion_1_18.retPerPago.periodo" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeAttribute("mesDesde", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde, 2, 0)));
      oWriter.writeAttribute("mesHasta", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta, 2, 0)));
      oWriter.writeAttribute("montoMensual", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual, 18, 2)));
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("mesDesde", gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde, false, false);
      AddObjectProperty("mesHasta", gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta, false, false);
      AddObjectProperty("montoMensual", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual, 18, 2)), false, false);
   }

   public byte getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual ;
   }

   public void setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual = DecimalUtil.ZERO ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N ;
   }

   public web.Sdtpresentacion_1_18_retPerPago_periodo Clone( )
   {
      return (web.Sdtpresentacion_1_18_retPerPago_periodo)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_retPerPago_periodo struct )
   {
      setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde(struct.getMesdesde());
      setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta(struct.getMeshasta());
      setgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual(struct.getMontomensual());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_retPerPago_periodo getStruct( )
   {
      web.StructSdtpresentacion_1_18_retPerPago_periodo struct = new web.StructSdtpresentacion_1_18_retPerPago_periodo ();
      struct.setMesdesde(getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde());
      struct.setMeshasta(getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta());
      struct.setMontomensual(getgxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta ;
   protected short readOk ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual ;
   protected boolean readElement ;
   protected boolean formatError ;
}

