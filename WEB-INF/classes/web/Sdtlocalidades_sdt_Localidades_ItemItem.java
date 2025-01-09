package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtlocalidades_sdt_Localidades_ItemItem extends GxUserType
{
   public Sdtlocalidades_sdt_Localidades_ItemItem( )
   {
      this(  new ModelContext(Sdtlocalidades_sdt_Localidades_ItemItem.class));
   }

   public Sdtlocalidades_sdt_Localidades_ItemItem( ModelContext context )
   {
      super( context, "Sdtlocalidades_sdt_Localidades_ItemItem");
   }

   public Sdtlocalidades_sdt_Localidades_ItemItem( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "Sdtlocalidades_sdt_Localidades_ItemItem");
   }

   public Sdtlocalidades_sdt_Localidades_ItemItem( StructSdtlocalidades_sdt_Localidades_ItemItem struct )
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
               gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod") )
            {
               gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod") )
            {
               gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom") )
            {
               gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCP") )
            {
               gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "localidades_sdt.Localidades.ItemItem" ;
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
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvCod", GXutil.trim( GXutil.str( gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCod", GXutil.trim( GXutil.str( gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocNom", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCP", GXutil.trim( GXutil.str( gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp, 8, 0)));
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
      AddObjectProperty("PaiCod", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod, false, false);
      AddObjectProperty("ProvCod", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod, false, false);
      AddObjectProperty("LocCod", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod, false, false);
      AddObjectProperty("LocNom", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom, false, false);
      AddObjectProperty("LocCP", gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp, false, false);
   }

   public short getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod = value ;
   }

   public short getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod = value ;
   }

   public short getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod = value ;
   }

   public String getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom( String value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom = value ;
   }

   public int getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp( int value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(1) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N ;
   }

   public web.Sdtlocalidades_sdt_Localidades_ItemItem Clone( )
   {
      return (web.Sdtlocalidades_sdt_Localidades_ItemItem)(clone()) ;
   }

   public void setStruct( web.StructSdtlocalidades_sdt_Localidades_ItemItem struct )
   {
      setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod(struct.getPaicod());
      setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod(struct.getProvcod());
      setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod(struct.getLoccod());
      setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom(struct.getLocnom());
      setgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp(struct.getLoccp());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtlocalidades_sdt_Localidades_ItemItem getStruct( )
   {
      web.StructSdtlocalidades_sdt_Localidades_ItemItem struct = new web.StructSdtlocalidades_sdt_Localidades_ItemItem ();
      struct.setPaicod(getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod());
      struct.setProvcod(getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod());
      struct.setLoccod(getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod());
      struct.setLocnom(getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom());
      struct.setLoccp(getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp());
      return struct ;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom ;
}

