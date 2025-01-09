package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtF1357_DeduccionesGenerales extends GxUserType
{
   public SdtF1357_DeduccionesGenerales( )
   {
      this(  new ModelContext(SdtF1357_DeduccionesGenerales.class));
   }

   public SdtF1357_DeduccionesGenerales( ModelContext context )
   {
      super( context, "SdtF1357_DeduccionesGenerales");
   }

   public SdtF1357_DeduccionesGenerales( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtF1357_DeduccionesGenerales");
   }

   public SdtF1357_DeduccionesGenerales( StructSdtF1357_DeduccionesGenerales struct )
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
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "Jub") )
            {
               gxTv_SdtF1357_DeduccionesGenerales_Jub = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OS") )
            {
               gxTv_SdtF1357_DeduccionesGenerales_Os = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CuotaSin") )
            {
               gxTv_SdtF1357_DeduccionesGenerales_Cuotasin = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
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
         sName = "F1357_DeduccionesGenerales" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("Jub", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Jub, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OS", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Os, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CuotaSin", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Cuotasin, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("Jub", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Jub, 16, 2)), false, false);
      AddObjectProperty("OS", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Os, 16, 2)), false, false);
      AddObjectProperty("CuotaSin", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_DeduccionesGenerales_Cuotasin, 16, 2)), false, false);
   }

   public java.math.BigDecimal getgxTv_SdtF1357_DeduccionesGenerales_Jub( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Jub ;
   }

   public void setgxTv_SdtF1357_DeduccionesGenerales_Jub( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Jub = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_DeduccionesGenerales_Os( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Os ;
   }

   public void setgxTv_SdtF1357_DeduccionesGenerales_Os( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Os = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Cuotasin ;
   }

   public void setgxTv_SdtF1357_DeduccionesGenerales_Cuotasin( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Cuotasin = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtF1357_DeduccionesGenerales_Jub = DecimalUtil.ZERO ;
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(1) ;
      gxTv_SdtF1357_DeduccionesGenerales_Os = DecimalUtil.ZERO ;
      gxTv_SdtF1357_DeduccionesGenerales_Cuotasin = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_N ;
   }

   public web.SdtF1357_DeduccionesGenerales Clone( )
   {
      return (web.SdtF1357_DeduccionesGenerales)(clone()) ;
   }

   public void setStruct( web.StructSdtF1357_DeduccionesGenerales struct )
   {
      setgxTv_SdtF1357_DeduccionesGenerales_Jub(struct.getJub());
      setgxTv_SdtF1357_DeduccionesGenerales_Os(struct.getOs());
      setgxTv_SdtF1357_DeduccionesGenerales_Cuotasin(struct.getCuotasin());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtF1357_DeduccionesGenerales getStruct( )
   {
      web.StructSdtF1357_DeduccionesGenerales struct = new web.StructSdtF1357_DeduccionesGenerales ();
      struct.setJub(getgxTv_SdtF1357_DeduccionesGenerales_Jub());
      struct.setOs(getgxTv_SdtF1357_DeduccionesGenerales_Os());
      struct.setCuotasin(getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin());
      return struct ;
   }

   protected byte gxTv_SdtF1357_DeduccionesGenerales_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Jub ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Os ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Cuotasin ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

