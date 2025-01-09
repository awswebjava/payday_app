package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConvenio_horasextras_porDia_old extends GxUserType
{
   public SdtConvenio_horasextras_porDia_old( )
   {
      this(  new ModelContext(SdtConvenio_horasextras_porDia_old.class));
   }

   public SdtConvenio_horasextras_porDia_old( ModelContext context )
   {
      super( context, "SdtConvenio_horasextras_porDia_old");
   }

   public SdtConvenio_horasextras_porDia_old( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtConvenio_horasextras_porDia_old");
   }

   public SdtConvenio_horasextras_porDia_old( StructSdtConvenio_horasextras_porDia_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvHsPDiaTipTra") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsPDiaDia") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsPDiaDesde") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveTarifaPDia") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveTarifaPDRec") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveTarifaPDCri") )
            {
               gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri = oReader.getValue() ;
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
         sName = "Convenio_horasextras_porDia_old" ;
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
      oWriter.writeElement("ConvHsPDiaTipTra", gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsPDiaDia", GXutil.trim( GXutil.str( gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsPDiaDesde", gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveTarifaPDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveTarifaPDRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveTarifaPDCri", gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
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
      AddObjectProperty("ConvHsPDiaTipTra", gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra, false, false);
      AddObjectProperty("ConveHsPDiaDia", gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia, false, false);
      AddObjectProperty("ConveHsPDiaDesde", gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde, false, false);
      AddObjectProperty("ConveTarifaPDia", gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia, false, false);
      AddObjectProperty("ConveTarifaPDRec", gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec, false, false);
      AddObjectProperty("ConveTarifaPDCri", gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri, false, false);
   }

   public String getgxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra = value ;
   }

   public byte getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia( byte value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia = value ;
   }

   public String getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde = value ;
   }

   public java.math.BigDecimal getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec = value ;
   }

   public String getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri ;
   }

   public void setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra = "" ;
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(1) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde = "" ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia = DecimalUtil.ZERO ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec = DecimalUtil.ZERO ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_N ;
   }

   public web.SdtConvenio_horasextras_porDia_old Clone( )
   {
      return (web.SdtConvenio_horasextras_porDia_old)(clone()) ;
   }

   public void setStruct( web.StructSdtConvenio_horasextras_porDia_old struct )
   {
      setgxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra(struct.getConvhspdiatiptra());
      setgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia(struct.getConvehspdiadia());
      setgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde(struct.getConvehspdiadesde());
      setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia(struct.getConvetarifapdia());
      setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec(struct.getConvetarifapdrec());
      setgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri(struct.getConvetarifapdcri());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConvenio_horasextras_porDia_old getStruct( )
   {
      web.StructSdtConvenio_horasextras_porDia_old struct = new web.StructSdtConvenio_horasextras_porDia_old ();
      struct.setConvhspdiatiptra(getgxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra());
      struct.setConvehspdiadia(getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia());
      struct.setConvehspdiadesde(getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde());
      struct.setConvetarifapdia(getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia());
      struct.setConvetarifapdrec(getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec());
      struct.setConvetarifapdcri(getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri());
      return struct ;
   }

   protected byte gxTv_SdtConvenio_horasextras_porDia_old_N ;
   protected byte gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia ;
   protected java.math.BigDecimal gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

