package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtF1357_GNSI extends GxUserType
{
   public SdtF1357_GNSI( )
   {
      this(  new ModelContext(SdtF1357_GNSI.class));
   }

   public SdtF1357_GNSI( ModelContext context )
   {
      super( context, "SdtF1357_GNSI");
   }

   public SdtF1357_GNSI( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtF1357_GNSI");
   }

   public SdtF1357_GNSI( StructSdtF1357_GNSI struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LRGravada") )
            {
               gxTv_SdtF1357_GNSI_F1357lrgravada = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGTotal") )
            {
               gxTv_SdtF1357_GNSI_F1357ldgtotal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDPTotalArt30") )
            {
               gxTv_SdtF1357_GNSI_F1357ldptotalart30 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DescuentosDeLey") )
            {
               gxTv_SdtF1357_GNSI_Descuentosdeley = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AnticiposDeSac") )
            {
               gxTv_SdtF1357_GNSI_Anticiposdesac = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "F1357_GNSI" ;
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
      oWriter.writeElement("F1357LRGravada", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357lrgravada, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGTotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357ldgtotal, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDPTotalArt30", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357ldptotalart30, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("DescuentosDeLey", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_Descuentosdeley, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AnticiposDeSac", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_Anticiposdesac, 16, 2)));
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
      AddObjectProperty("F1357LRGravada", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357lrgravada, 16, 2)), false, false);
      AddObjectProperty("F1357LDGTotal", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357ldgtotal, 16, 2)), false, false);
      AddObjectProperty("F1357LDPTotalArt30", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_F1357ldptotalart30, 16, 2)), false, false);
      AddObjectProperty("DescuentosDeLey", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_Descuentosdeley, 16, 2)), false, false);
      AddObjectProperty("AnticiposDeSac", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GNSI_Anticiposdesac, 16, 2)), false, false);
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GNSI_F1357lrgravada( )
   {
      return gxTv_SdtF1357_GNSI_F1357lrgravada ;
   }

   public void setgxTv_SdtF1357_GNSI_F1357lrgravada( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357lrgravada = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GNSI_F1357ldgtotal( )
   {
      return gxTv_SdtF1357_GNSI_F1357ldgtotal ;
   }

   public void setgxTv_SdtF1357_GNSI_F1357ldgtotal( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357ldgtotal = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GNSI_F1357ldptotalart30( )
   {
      return gxTv_SdtF1357_GNSI_F1357ldptotalart30 ;
   }

   public void setgxTv_SdtF1357_GNSI_F1357ldptotalart30( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357ldptotalart30 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GNSI_Descuentosdeley( )
   {
      return gxTv_SdtF1357_GNSI_Descuentosdeley ;
   }

   public void setgxTv_SdtF1357_GNSI_Descuentosdeley( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_Descuentosdeley = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GNSI_Anticiposdesac( )
   {
      return gxTv_SdtF1357_GNSI_Anticiposdesac ;
   }

   public void setgxTv_SdtF1357_GNSI_Anticiposdesac( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_Anticiposdesac = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtF1357_GNSI_F1357lrgravada = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GNSI_N = (byte)(1) ;
      gxTv_SdtF1357_GNSI_F1357ldgtotal = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GNSI_F1357ldptotalart30 = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GNSI_Descuentosdeley = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GNSI_Anticiposdesac = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtF1357_GNSI_N ;
   }

   public web.SdtF1357_GNSI Clone( )
   {
      return (web.SdtF1357_GNSI)(clone()) ;
   }

   public void setStruct( web.StructSdtF1357_GNSI struct )
   {
      setgxTv_SdtF1357_GNSI_F1357lrgravada(struct.getF1357lrgravada());
      setgxTv_SdtF1357_GNSI_F1357ldgtotal(struct.getF1357ldgtotal());
      setgxTv_SdtF1357_GNSI_F1357ldptotalart30(struct.getF1357ldptotalart30());
      setgxTv_SdtF1357_GNSI_Descuentosdeley(struct.getDescuentosdeley());
      setgxTv_SdtF1357_GNSI_Anticiposdesac(struct.getAnticiposdesac());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtF1357_GNSI getStruct( )
   {
      web.StructSdtF1357_GNSI struct = new web.StructSdtF1357_GNSI ();
      struct.setF1357lrgravada(getgxTv_SdtF1357_GNSI_F1357lrgravada());
      struct.setF1357ldgtotal(getgxTv_SdtF1357_GNSI_F1357ldgtotal());
      struct.setF1357ldptotalart30(getgxTv_SdtF1357_GNSI_F1357ldptotalart30());
      struct.setDescuentosdeley(getgxTv_SdtF1357_GNSI_Descuentosdeley());
      struct.setAnticiposdesac(getgxTv_SdtF1357_GNSI_Anticiposdesac());
      return struct ;
   }

   protected byte gxTv_SdtF1357_GNSI_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357lrgravada ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357ldgtotal ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357ldptotalart30 ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_Descuentosdeley ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_Anticiposdesac ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

