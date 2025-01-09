package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtloc_sdt_Localidades_Item extends GxUserType
{
   public Sdtloc_sdt_Localidades_Item( )
   {
      this(  new ModelContext(Sdtloc_sdt_Localidades_Item.class));
   }

   public Sdtloc_sdt_Localidades_Item( ModelContext context )
   {
      super( context, "Sdtloc_sdt_Localidades_Item");
   }

   public Sdtloc_sdt_Localidades_Item( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtloc_sdt_Localidades_Item");
   }

   public Sdtloc_sdt_Localidades_Item( StructSdtloc_sdt_Localidades_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_Sdtloc_sdt_Localidades_Item_Paicod = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod") )
            {
               gxTv_Sdtloc_sdt_Localidades_Item_Provcod = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod") )
            {
               gxTv_Sdtloc_sdt_Localidades_Item_Loccod = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom") )
            {
               gxTv_Sdtloc_sdt_Localidades_Item_Locnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCP") )
            {
               gxTv_Sdtloc_sdt_Localidades_Item_Loccp = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "loc_sdt.Localidades.Item" ;
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
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.strNoRound( gxTv_Sdtloc_sdt_Localidades_Item_Paicod, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvCod", GXutil.trim( GXutil.strNoRound( gxTv_Sdtloc_sdt_Localidades_Item_Provcod, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCod", GXutil.trim( GXutil.strNoRound( gxTv_Sdtloc_sdt_Localidades_Item_Loccod, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocNom", gxTv_Sdtloc_sdt_Localidades_Item_Locnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCP", GXutil.trim( GXutil.strNoRound( gxTv_Sdtloc_sdt_Localidades_Item_Loccp, 10, 5)));
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
      AddObjectProperty("PaiCod", gxTv_Sdtloc_sdt_Localidades_Item_Paicod, false, false);
      AddObjectProperty("ProvCod", gxTv_Sdtloc_sdt_Localidades_Item_Provcod, false, false);
      AddObjectProperty("LocCod", gxTv_Sdtloc_sdt_Localidades_Item_Loccod, false, false);
      AddObjectProperty("LocNom", gxTv_Sdtloc_sdt_Localidades_Item_Locnom, false, false);
      AddObjectProperty("LocCP", gxTv_Sdtloc_sdt_Localidades_Item_Loccp, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtloc_sdt_Localidades_Item_Paicod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Paicod ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_Paicod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Paicod = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtloc_sdt_Localidades_Item_Provcod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Provcod ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_Provcod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Provcod = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtloc_sdt_Localidades_Item_Loccod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Loccod ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_Loccod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccod = value ;
   }

   public String getgxTv_Sdtloc_sdt_Localidades_Item_Locnom( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Locnom ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_Locnom( String value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Locnom = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtloc_sdt_Localidades_Item_Loccp( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Loccp ;
   }

   public void setgxTv_Sdtloc_sdt_Localidades_Item_Loccp( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccp = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_Paicod = DecimalUtil.ZERO ;
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(1) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Provcod = DecimalUtil.ZERO ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccod = DecimalUtil.ZERO ;
      gxTv_Sdtloc_sdt_Localidades_Item_Locnom = "" ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccp = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_N ;
   }

   public web.Sdtloc_sdt_Localidades_Item Clone( )
   {
      return (web.Sdtloc_sdt_Localidades_Item)(clone()) ;
   }

   public void setStruct( web.StructSdtloc_sdt_Localidades_Item struct )
   {
      setgxTv_Sdtloc_sdt_Localidades_Item_Paicod(struct.getPaicod());
      setgxTv_Sdtloc_sdt_Localidades_Item_Provcod(struct.getProvcod());
      setgxTv_Sdtloc_sdt_Localidades_Item_Loccod(struct.getLoccod());
      setgxTv_Sdtloc_sdt_Localidades_Item_Locnom(struct.getLocnom());
      setgxTv_Sdtloc_sdt_Localidades_Item_Loccp(struct.getLoccp());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtloc_sdt_Localidades_Item getStruct( )
   {
      web.StructSdtloc_sdt_Localidades_Item struct = new web.StructSdtloc_sdt_Localidades_Item ();
      struct.setPaicod(getgxTv_Sdtloc_sdt_Localidades_Item_Paicod());
      struct.setProvcod(getgxTv_Sdtloc_sdt_Localidades_Item_Provcod());
      struct.setLoccod(getgxTv_Sdtloc_sdt_Localidades_Item_Loccod());
      struct.setLocnom(getgxTv_Sdtloc_sdt_Localidades_Item_Locnom());
      struct.setLoccp(getgxTv_Sdtloc_sdt_Localidades_Item_Loccp());
      return struct ;
   }

   protected byte gxTv_Sdtloc_sdt_Localidades_Item_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Paicod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Provcod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Loccod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Loccp ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtloc_sdt_Localidades_Item_Locnom ;
}

